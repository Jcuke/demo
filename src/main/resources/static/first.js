$(function () {
    //$('#time').html(new Date().toLocaleString());
    setInterval("$('#time').html('Drag me ' + new Date().toLocaleString());",1000);
    setInterval("$('#time').css('background-color', 'yellow');$('#time').css('color', 'black');",1500);
    setInterval("$('#time').css('background-color', 'pink');$('#time').css('color', 'blue');",2000);
    setInterval("$('#time').css('background-color', 'green');$('#time').css('color', '#FF11FF');",2500);

    var rDrag = {
        o:null,
        init:function(o){
            o.onmousedown = this.start;
        },
        start:function(e){
            var o;
            e = rDrag.fixEvent(e);
            e.preventDefault && e.preventDefault();
            rDrag.o = o = this;
            o.x = e.clientX - rDrag.o.offsetLeft;
            o.y = e.clientY - rDrag.o.offsetTop;
            document.onmousemove = rDrag.move;
            document.onmouseup = rDrag.end;
        },
        move:function(e){
            e = rDrag.fixEvent(e);
            var oLeft,oTop;
            oLeft = e.clientX - rDrag.o.x;
            oTop = e.clientY - rDrag.o.y;
            rDrag.o.style.left = oLeft + 'px';
            rDrag.o.style.top = oTop + 'px';
        },
        end:function(e){
            e = rDrag.fixEvent(e);
            rDrag.o = document.onmousemove = document.onmouseup = null;
        },
        fixEvent: function(e){
            if (!e) {
                e = window.event;
                e.target = e.srcElement;
                e.layerX = e.offsetX;
                e.layerY = e.offsetY;
            }
            return e;
        }
    };
    rDrag.init($('#time')[0]);//回忆起很早老马说的话，dom对象转jquery对象时加[0]

    $('button,select,div').addClass('border-radius-ten-px');

    //$(button).addClass()

    //显示遮罩层
    var showMask = function showMask(){
        $("#mask").css("height",screen.height);
        $("#mask").css("width",screen.width);
        //$("#mask").css("height",document.body.clientHeight);
        //$("#mask").css("width",document.body.clientHeight);
        $("#mask").show();
    };
    //隐藏遮罩层
    var hideMask = function hideMask(){
        $("#mask").css("height",0);
        $("#mask").css("width",0);
        $("#mask").hide();
    };

    showMask();
    $('#divBody').css("height",screen.height * 0.75);
    $('#chartdiv').css("height",screen.height * 0.7);
    $('#chartdiv3').css("height",screen.height * 0.7);

    $('#crwalBtn').click(function () {
        var cityid = $('#select1').val();
        $.get("crawlByCityid/" + cityid, function (data) {
            alert(data);
        });
    });

    $.get("getCityNames", function (data) {
        for (x in data) {
            $('#select1').append($("<option>").text(data[x].city).val(data[x].cityid));
            hideMask();
        }
    });

    /**
     * 单个城市数据
     */
    $('#btnFyCount').click(function (data) {
        showMask();
        var cityid = $('#select1').val();
        $.get("getEachDistrictFyCount/" + cityid, function (data) {
            hideMask();
            $('#chartdiv2').html(data);
            if (data.length == 0) {
                $('#tishi').show();
            } else {
                $('#tishi').hide();
            }
            var chartData = {
                "2017": data
            };

            /**
             * Create the chart
             */
            var currentYear = 2017;
            var chart = AmCharts.makeChart("chartdiv", {
                "type": "pie",
                "theme": "light",
                "dataProvider": [],
                "valueField": "count",
                "titleField": "district",
                "startDuration": 0,
                "innerRadius": 80,
                "pullOutRadius": 20,
                "marginTop": 30,
                "titles": [{
                    "text": "房源分布"
                }],
                "allLabels": [{
                    "y": "54%",
                    "align": "center",
                    "size": 25,
                    "bold": true,
                    "text": "1995",
                    "color": "#51e30c"
                }, {
                    "y": "49%",
                    "align": "center",
                    "size": 15,
                    "text": "Year",
                    "color": "#51e30c"
                }],
                "listeners": [{
                    "event": "init",
                    "method": function (e) {
                        var chart = e.chart;

                        function getCurrentData() {
                            var data = chartData[currentYear];
                            currentYear++;
                            if (currentYear > 2014)
                                currentYear = 1995;
                            return data;
                        }

                        function loop() {
                            chart.allLabels[0].text = currentYear;
                            var data = getCurrentData();
                            chart.animateData(data, {
                                duration: 1000,
                                complete: function () {
                                    setTimeout(loop, 3000);
                                }
                            });
                        }

                        loop();
                    }
                }],
                "export": {
                    "enabled": true
                }
            });
        });
    });

    /**
     * 单个城市数据
     */
    $('#btn').click(function () {
        showMask();
        var cityid = $('#select1').val();
        $.get("getWhEachDistrictData/" + cityid, function (data) {
            $('#chartdiv2').html(data);
            if (data.length == 0) {
                $('#tishi').show();
            } else {
                $('#tishi').hide();
            }
            var chart = AmCharts.makeChart("chartdiv", {
                "type": "serial",
                "theme": "light",
                "categoryField": "district",
                "rotate": true,
                "startDuration": 1,
                "categoryAxis": {
                    "gridPosition": "start",
                    "position": "left"
                },
                "trendLines": [],
                "graphs": [
                    {
                        "balloonText": "[[value]]元/m2   ",
                        "fillAlphas": 0.8,
                        "id": "AmGraph-2",
                        "lineAlpha": 0.2,
                        "title": "Expenses",
                        "type": "column",
                        "valueField": "jiage"
                    }
                ],
                "guides": [],
                "valueAxes": [
                    {
                        "id": "ValueAxis-1",
                        "position": "top",
                        "axisAlpha": 0
                    }
                ],
                "allLabels": [],
                "balloon": {},
                "titles": [],
                "dataProvider": data,
                "export": {
                    "enabled": true
                }
            });
            hideMask();
        });
    });

    /**
     * 全国数据
     */
    $('#btn3').click(function () {
        showMask();
        $.get("getEachCityData", function (data) {
            $('#chartdiv4').html(data);
            if (data.length == 0) {
                $('#tishi3').show();
            } else {
                $('#tishi3').hide();
            }
            var chart = AmCharts.makeChart("chartdiv3", {
                "type": "serial",
                "theme": "light",
                "categoryField": "city",
                "rotate": true,
                "startDuration": 1,
                "categoryAxis": {
                    "gridPosition": "start",
                    "position": "left"
                },
                "trendLines": [],
                "graphs": [
                    {
                        "balloonText": "[[value]]元/m2   ",
                        "fillAlphas": 0.8,
                        "id": "AmGraph-2",
                        "lineAlpha": 0.2,
                        "title": "Expenses",
                        "type": "column",
                        "valueField": "jiage"
                    }
                ],
                "guides": [],
                "valueAxes": [
                    {
                        "id": "ValueAxis-1",
                        "position": "top",
                        "axisAlpha": 0
                    }
                ],
                "allLabels": [],
                "balloon": {},
                "titles": [],
                "dataProvider": data,
                "export": {
                    "enabled": true
                }
            });
            hideMask();
        });
    });

    /**
     * 全国数据
     */
    $('#btnFyCount3').click(function () {
        showMask();
        $.get("getEachCityFyCount", function (data) {
            $('#chartdiv4').html(data);
            if (data.length == 0) {
                $('#tishi3').show();
            } else {
                $('#tishi3').hide();
            }
            var chartData = {
                "2017": data
            };

            /**
             * Create the chart
             */
            var currentYear = 2017;
            var chart = AmCharts.makeChart("chartdiv3", {
                "type": "pie",
                "theme": "light",
                "dataProvider": [],
                "valueField": "count",
                "titleField": "city",
                "startDuration": 0,
                "innerRadius": 80,
                "pullOutRadius": 20,
                "marginTop": 30,
                "titles": [{
                    "text": "房源分布"
                }],
                "allLabels": [{
                    "y": "54%",
                    "align": "center",
                    "size": 25,
                    "bold": true,
                    "text": "1995",
                    "color": "#51e30c"
                }, {
                    "y": "49%",
                    "align": "center",
                    "size": 15,
                    "text": "Year",
                    "color": "#51e30c"
                }],
                "listeners": [{
                    "event": "init",
                    "method": function (e) {
                        var chart = e.chart;

                        function getCurrentData() {
                            var data = chartData[currentYear];
                            currentYear++;
                            if (currentYear > 2014)
                                currentYear = 1995;
                            return data;
                        }

                        function loop() {
                            chart.allLabels[0].text = currentYear;
                            var data = getCurrentData();
                            chart.animateData(data, {
                                duration: 1000,
                                complete: function () {
                                    setTimeout(loop, 3000);
                                }
                            });
                        }

                        loop();
                    }
                }],
                "export": {
                    "enabled": true
                }
            });
            hideMask();
        });
    });
});