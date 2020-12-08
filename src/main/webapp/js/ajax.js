function createAJAX(){
    var httpRequest;
    if(window.XMLHttpRequest) {
        //在IE6以上的版本以及其他内核的浏览器(Mozilla)等
        httpRequest = new XMLHttpRequest();
    }else if(window.ActiveXObject) {

        //在IE6以下的版本
        httpRequest = new ActiveXObject();
    }
    return httpRequest;
}