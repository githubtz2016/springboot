$(function () {
    ajax_sync("/hailwayLine/getAllHailwayLine","post",{},function (responseData) {
        for(var i=0;i<responseData.length;i++){
            var line="<option value='"+responseData[i].id+"'>"+responseData[i].name+"</option>";
            $("#road_secton").append(line);

        }

    })
})