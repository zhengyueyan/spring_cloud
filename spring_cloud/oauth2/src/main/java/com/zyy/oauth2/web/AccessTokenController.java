package com.zyy.oauth2.web;

//import org.apache.oltu.oauth2.as.issuer.MD5Generator;
//import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
//import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
//import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
//import org.apache.oltu.oauth2.as.response.OAuthASResponse;
//import org.apache.oltu.oauth2.common.OAuth;
//import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
//import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
//import org.apache.oltu.oauth2.common.message.OAuthResponse;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 * description
 *
 * @author zhengyueyan
 * @date 15:24 2018/8/20
 */
//@Controller
public class AccessTokenController {

    /**
     * 获取客户端的code码，向客户端返回access token
     * @param request
     * @return
     */
//    @RequestMapping(value="/responseAccessToken",method = RequestMethod.POST)
//    public HttpEntity token(HttpServletRequest request){
//        System.out.println("--------服务端/responseAccessToken-----------------------------------------------------------");
//        OAuthIssuer oauthIssuerImpl = null;
//        OAuthResponse response = null;
//        //构建OAuth请求
//        try {
//            OAuthTokenRequest oauthRequest =new OAuthTokenRequest(request);
//            String authCode =oauthRequest.getParam(OAuth.OAUTH_CODE);
//            String clientSecret = oauthRequest.getClientSecret();
//            if(clientSecret!=null||clientSecret!=""){
//                //生成Access Token
//                oauthIssuerImpl =new OAuthIssuerImpl(new MD5Generator());
//                final String accessToken =oauthIssuerImpl.accessToken();
//                System.out.println(accessToken);
//                System.out.println("--oooo---");
//                //生成OAuth响应
//                response = OAuthASResponse
//                        .tokenResponse(HttpServletResponse.SC_OK)
//                        .setAccessToken(accessToken)
//                        .buildJSONMessage();
//            }
//            System.out.println("--------服务端/responseAccessToken-----------------------------------------------------------");
//
//            //根据OAuthResponse生成ResponseEntity
//            return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
//        } catch (OAuthSystemException e) {
//            e.printStackTrace();
//        } catch (OAuthProblemException e) {
//            e.printStackTrace();
//        }
//        System.out.println("--------服务端/responseAccessToken-----------------------------------------------------------");
//        return null;
//    }

}
