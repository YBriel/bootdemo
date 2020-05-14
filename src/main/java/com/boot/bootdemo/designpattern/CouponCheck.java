package com.boot.bootdemo.designpattern;

/**
 * author: yuzq
 * create: 2020-04-17 11:09
 **/

public abstract class CouponCheck {

    protected String phone;

    protected String batchNum;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public CouponCheck() {
    }

    public CouponCheck(String phone, String batchNum) {
        this.phone = phone;
        this.batchNum = batchNum;


    }


/*    private CouponServiceImpl couponService;

    public void couponService(CouponServiceImpl couponService){
        this.couponService=couponService;
    }*/

    public abstract void   initParam(String  phone, String batchNum);

    //public abstract String   allocate();

    public String invokeAllocate(){
        //todo 校验手机号码和批次号参数
        if(!phone.equals("111")){
            return "手机号错误";
        }
        CouponServiceImpl couponService=new CouponServiceImpl();
        return couponService.allocateCoupon(phone, batchNum);
    }
}
