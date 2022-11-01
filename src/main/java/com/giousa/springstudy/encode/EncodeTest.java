package com.giousa.springstudy.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * url编码和解码
 */
public class EncodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        String sourceUrl = "https://h5.test.shantaijk.cn/health_report/#/base";
//        String encodeUrl = URLEncoder.encode(sourceUrl, "utf-8");
//        System.out.println("编码：");
//        System.out.println(encodeUrl);
//
//        String url = "https%3A%2F%2Fh5.test.shantaijk.cn%2Fhealth_report%2F%23%2Fbase";
//        String decodeUrl = URLDecoder.decode(url, "utf-8");
//        System.out.println("解码：");
//        System.out.println(decodeUrl);
//        String sourceUrl = "https://h5.test.shantaijk.cn/health_report/#/base";
//
//        String workbenchUrl = sourceUrl+"?userId={{userId}}";
//        String sourceUrl2 = sourceUrl+"?bizType=CONSULT_ORDER_ID&bizId=consultOrderId";
//        String xcxUrl = "xcx://xcx/pages/bridge/webview/index?url="+encode(sourceUrl2);
//        String wxUrl = "xcx://xcx/pages/bridge/webview/index.html?url="+encode(sourceUrl2);
//        String h5Url = sourceUrl2;
//
//        System.out.println("workbenchUrl:");
//        System.out.println(workbenchUrl);
//        System.out.println("xcxUrl:");
//        System.out.println(xcxUrl);
//        System.out.println("wxUrl:");
//        System.out.println(wxUrl);
//        System.out.println("h5Url:");
//        System.out.println(h5Url);

//        String url = "https%3A%2F%2Fh5.test.shantaijk.cn%2Fcommonh5%2Findex.html%23%2Forder-sales%3Fid%3D20210825000000000000000000741075%26otherBusinessType%3DActivateBind%26otherBusinessNo%3D${entranceDoctorId}%26wxGroupId%3D${wxGroupId}";
//        String url = "xcx://xcx/pages/bridge/webview/index.html?url=https%3A%2F%2Fh5.test.shantaijk.cn%2Fcommonh5%2Findex.html%23%2Forder-sales%3Fid%3D20210825000000000000000000741075%26otherBusinessType%3DActivateBind%26otherBusinessNo%3D${entranceDoctorId}%26wxGroupId%3D${wxGroupId}%26callBackUrl%3D%252F%252Fh5.test.shantaijk.cn%252Ftahiti%252Fredirector-private-doctor.html%253FotherBusinessType%253DActivateBind%2526otherBusinessNo%253D${entranceDoctorId}%2526wxGroupId%253D${wxGroupId}";
//        System.out.println(decode(url));

//        String url2 = "https://h5.shantaijk.cn/commonh5/index.html#/order-sales?id=20210830000000000000000000256266&otherBusinessType=ActivateBind&otherBusinessNo=entranceDoctorId&shareOperatorNo=wxGroupId&shareSource=WECHATGRUOP";
//        String encode = encode(url2);
//        System.out.println(encode);

        String url = "https://h5.test.shantaijk.cn/health_report/#/collect";

        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");

        String join = String.join(",", list);
        System.out.println(join);

    }

    private static String getSourceUrl(){
        String encodeUrl = "https%3A%2F%2Fh5.test.shantaijk.cn%2Fhealth_report%2F%23%2Fbase";
        return decode(encodeUrl);
    }

    private static String encode(String sourceUrl){
        try {
            return URLEncoder.encode(sourceUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("编码异常");
        }
        return null;
    }

    private static String decode(String encodeUrl){
        try {
            return URLDecoder.decode(encodeUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("解码异常");
        }
        return null;
    }


}
