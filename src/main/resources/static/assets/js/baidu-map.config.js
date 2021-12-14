(function() {
    var map = new BMap.Map('map', {
        enableMapClick: false
    });
    var point = new BMap.Point(111.848937,40.904095);
    map.centerAndZoom(point, 15);
    map.enableScrollWheelZoom();
    map.disableDoubleClickZoom();
    map.setDefaultCursor('pointer');
    map.closeInfoWindow();

    window.BaiduMap = map;
})();