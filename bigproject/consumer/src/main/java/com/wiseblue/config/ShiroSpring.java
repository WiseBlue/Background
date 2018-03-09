package com.wiseblue.config;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.remoting.SecureRemoteInvocationExecutor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

;

/**
 * Created by LiZhikang on 2018/2/10.
 */
@Configuration
public class ShiroSpring {
    /**
     * Shiro提供了与Web集成的支持，其通过一个shiroFilter入口来拦截需要安全控制的URL，然后进行相应的
     * 控制，shiroFilter类似web框架的前端控制器，是安全控制的入口点，其负责读取配置，然后判断URL是否
     * 需要登录、权限等工作
     *
     * Shiro拦截器 anon匿名访问（不需要登录就可以访问） authc需要登录才可以访问 logout注销
     *
     * URL匹配模式（Ant风格模式）
     * Ant通配符支持？、*、**，注意通配符匹配不包括目录分隔符"/"
     * -？：匹配一个字符，如/admin?将匹配/admin1，但不匹配/admin或/admin/
     * -*:匹配0个或多个字符串，如/admin将匹配/admin、/admin123，但不匹配/admin1
     * -**:匹配路径中的0个或多个路径，如/admin/**将匹配/admin/a或/admin/a/b
     *
     * URL匹配顺序
     *URL使用第一次匹配优先的策略，即从头开始选择第一个匹配的拦截器
     * @param securityManager
     * @return
     */


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        //设置SecurityManager
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //拦截器
        Map<String,String> filterChainDefinations=new HashMap<>();
        filterChainDefinations.put("/","anon");
        filterChainDefinations.put("*","authc");

        //默认寻找页面
        shiroFilterFactoryBean.setLoginUrl("/index.html");
        //登录成功界面
        shiroFilterFactoryBean.setSuccessUrl("/templates/bookshop.html");
        //登录失败界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/templates/error.html");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinations);

        return  shiroFilterFactoryBean;
    }

    @Bean(name="securityManager")
    public SecurityManager securityManager(UserRealm userRealm){
        DefaultWebSecurityManager defaultSecurityManager=new DefaultWebSecurityManager();
//        defaultSecurityManager.setCacheManager(cacheManager);
        defaultSecurityManager.setRealm(userRealm);
        return defaultSecurityManager;
    }

   /* @Bean(name = "cacheManager")
    public CacheManager cacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return ehCacheManager;
    }*/

    @Bean
    public UserRealm userRealm(CredentialsMatcher credentialsMatcher){
        UserRealm userRealm=new UserRealm();
        userRealm.setName("userRealm");
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }

    @Bean(name = "credentialsMatcher")
    public CredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    /**
     * 必须要有这样的实例，用来管理在Spring容器中常见的shiro对象
     * @return
     */
    @Bean(name="lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    /**
     * DelegatingFilterProxy代理模式
     * DelegatingFilterProxy：用来到Spring容器中去找与filter-name名字相同的bean实例
     * @return
     */
    @Bean
    @DependsOn(value = "lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true); // it's false by default
        return creator;
    }

    /**
     * 启用shiro注解
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public SecureRemoteInvocationExecutor secureRemoteInvocationExecutor(SecurityManager securityManager){
        SecureRemoteInvocationExecutor secureRemoteInvocationExecutor=new SecureRemoteInvocationExecutor();
        secureRemoteInvocationExecutor.setSecurityManager(securityManager);
        return secureRemoteInvocationExecutor;
    }

    /**
     * 处理异常跳转
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties exceptionMappers = new Properties();
        exceptionMappers.setProperty("org.apache.shiro.authz.UnauthorizedException", "403");
        exceptionMappers.setProperty("org.apache.shiro.authz.UnauthenticatedException", "403");
        simpleMappingExceptionResolver.setExceptionMappings(exceptionMappers);
        return simpleMappingExceptionResolver;
    }


}
