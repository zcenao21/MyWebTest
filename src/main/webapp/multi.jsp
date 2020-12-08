<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多级联动</title>
    <script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>

<%--############前台页面###################--%>
<select name="province" id="provinceId">
    <option value="-1">请选择省份</option>
    <option>广东</option>
    <option>湖南</option>
</select>
<select name="city" id="cityId">
    <option>请选择城市</option>
</select>

<%--############AJAX###################--%>

<script type="text/javascript">

    document.getElementById("provinceId").onchange = function () {


        /**********定位到下拉框，获取下拉框的值***************/
        // 获取选中的下拉框索引值
        var index = this.selectedIndex;
        // 得到下拉框的值
        var province = this.options[index].innerHTML;

        //下拉框的值要是“请选择”，那么我们是不会访问服务器的
        if ("请选择省份" != province) {

            /********由于每次都会自动添加，因此每次在调用的时候清除***********/
            var citySelect = document.getElementById("cityId");

            //每次都将option变成长度只有1的
            citySelect.options.length = 1;

            /*************ajax代码*********************/
            //创建AJAX对象
            var ajax = createAJAX();
            //准备发送请求
            var method = "post";
            var url = "${pageContext.request.contextPath}/ProvinceServlet?time=" + new Date().getTime();
            ajax.open(method, url);
            //由于是POST方式，因此要设置头
            ajax.setRequestHeader("content-type", "application/x-www-form-urlencoded");

            ajax.send("province=" + province);

            /************ajax回调函数*********************/
            ajax.onreadystatechange = function () {

                if (ajax.readyState == 4) {
                    if (ajax.status == 200) {

                        //得到服务器端带过来的XML
                        var XMLDocument = ajax.responseXML;

                        /**********解析XML文档，使用DOM写到下拉框中****************/
                        var cities = XMLDocument.getElementsByTagName("city");

                        //得到每一个cities节点的值，动态生成下拉框，添加到下拉框中
                        for (var i = 0; i < cities.length; i++) {
                            var value = cities[i].firstChild.nodeValue;
                            //动态生成下拉框
                            var optionElement = document.createElement("option");
                            optionElement.innerHTML = value;

                            //添加到下拉框中
                            citySelect.appendChild(optionElement);

                        }
                    }
                }
            };

        }

    };

</script>


</body>
</html>
