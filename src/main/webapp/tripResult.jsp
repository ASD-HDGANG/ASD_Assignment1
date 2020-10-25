<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: daohuxia
  Date: 23/9/20
  Time: 3:11 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC"-//W3C//DTD HTML 4.01Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>线路规划</title>
    <script type="text/javascript" src="//api.map.baidu.com/api?type=subway&v=1.0&ak=Ra1wFDOvDC9OGt1RNwp9kYIL5OB2uSHZ"></script>
    <style type="text/css">
        #container{height:100%}
    </style>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
    String departure =request.getParameter("departure");
    String destination =request.getParameter("destination");%>

<div id="container"></div>
<script type="text/javascript">


    var departure = "<%=departure%>";
    var destination = "<%=destination%>";


    /**
     * 从所有城市列表中获取北京信息
     * 结果格式
     * {
     *     keyword: 'beijing',
     *     name: '北京',
     *     citycode: '131'
     * }
     */
    /* globals BMapSub */

    var subwayCityName = '北京';
    var list = BMapSub.SubwayCitiesList;
    var subwaycity = null;
    for (var i = 0; i < list.length; i++) {
        if (list[i].name === subwayCityName) {
            subwaycity = list[i];
            break;
        }
    }
    // 获取北京地铁数据-初始化地铁图
    var subway = new BMapSub.Subway('container', subwaycity.citycode);
    var zoomControl  = new BMapSub.ZoomControl({
        anchor: BMAPSUB_ANCHOR_BOTTOM_RIGHT,
        offset: new BMapSub.Size(10,100)
    });
    subway.addControl(zoomControl);
    subway.addEventListener('subwayloaded', function() {
        var drct = new BMapSub.Direction(subway);
        drct.search(departure,destination);
    });
    subway.addEventListener('directioncomplete', function() {
        alert('可以自定义点击详情后的操作！');
    });
</script>
</body>
</html>