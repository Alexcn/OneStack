function show_result() {
    $("#result-modal-salt").modal("show");
}

function collapse(obj){
    //$(".panel-collapse").collapse('toggle');
    var newstate = $(obj).attr('state') ^ 1, text = newstate ? "折叠":"展开";
    if(newstate==1){
        $(".panel-collapse").collapse('show');
    } else{
        $(".panel-collapse").collapse('hide');
    }
    $(obj).html(text + "所有");
    $(obj).attr('state', newstate);
}

function remote_exec(obj, rtype, url) {
    var f=$(obj).closest("form");
    var tgt_select=f.find("select[name='tgt_select']").val();
    if(rtype=="exec"){
        var arg=f.find("input[name='arg']").val();
    }else{
        var arg=f.find("select[name='module_list']").val();
    }
    if(tgt_select=="" || tgt_select==null || arg=="" || arg==undefined){
        $("#accordion").html("请选择主机/模块或者输入远程命令");
        $("#result-modal-salt").modal("show");
        return false;
    }
    $(".loading").show();
    $.ajax({
        type:"POST",
        url:url,
        data:{tgt_select:tgt_select, arg:arg, check_type:obj.name},
        dataType:"html",
        success:function (ret) {
            $(".loading").hide();
            var ret=JSON.parse(ret);
            var html="";
            $.each(ret.result, function (i, item) {
                if(item.iftrue==0){
                    color = "66d9ef";
                }else if(item.iftrue==1){
                    color = "e6db74";
                }else{
                    color = "f92672";
                }
                $.each(item, function(k,v){
                    if(k!="iftrue"){
                        if(rtype=="exec"){
                            html = html + "<div class='panel panel-default' style='background:#272822;border:none;'><div><b style='color: #" + color
                               + "'>主机：<a data-toggle='collapse' data-parent='#accordion' href='#" +
                               k.replace(/[.]/g,"") + "' style='color: #" + color + "'>" + k + "</a></b></div><b><div id='" + k.replace(/[.]/g,"")
                               + "' class='panel-collapse collapse'><div><p class='mydashed'>结果：</b><br />" + v + "</p></div></div></div>";
                        } else{
                            html = html + "<div class='panel panel-default' style='background:#272822;border:none;'><div><b style='color: #" + color
                                + "'>主机：<a data-toggle='collapse' data-parent='#accordion' href='#" +
                                k.replace(/[.]/g,"") + "' style='color: #" + color + "'>" + k + "</a></b></div><b><div id='" + k.replace(/[.]/g,"")
                                + "' class='panel-collapse collapse'><div><p class='mydashed'>结果：</b><br />";
                            $.each(v, function (m,n) {
                                html = html + "<b>" + m.split('|')[0] + "</b><br />" + n + "<br />";
                            })
                            html = html + "</p></div></div></div>";
                        }
                    }
                })
            })
            // if(ret.check==0){
            //     color = "66d9ef";
            // }else if(ret.check==1){
            //     color = "e6db74";
            // }else{
            //     color = "f92672";
            // }
            // if(rtype=="exec"){
            //     $.each(ret.sret, function (i, item) {
            //         html = html + "<div class='panel panel-default' style='background:#272822;border:none;'><div><b style='color: #" + color + "'>主机：<a data-toggle='collapse' data-parent='#accordion' href='#" +
            //             i.replace(/[.]/g,"") + "' style='color: #" + color + "'>" + i + "</a></b></div><b><div id='" + i.replace(/[.]/g,"")
            //             + "' class='panel-collapse collapse'><div><p class='mydashed'>结果：</b><br />" + item + "</p></div></div></div>";
            //     })
            // }else{
            //     $.each(ret.sret, function(i, item){
            //         html = html + "<div class='panel panel-default' style='background:#272822;border:none;'><div><b style='color: #" + color + "'>主机：<a data-toggle='collapse' data-parent='#accordion' href='#" +
            //             i.replace(/[.]/g,"") + "' style='color: #" + color + "'>" + i + "</a></b></div><b><div id='" + i.replace(/[.]/g,"")
            //             + "' class='panel-collapse collapse'><div><p class='mydashed'>结果：</b><br />";
            //         $.each(item, function (k,v) {
            //             html = html + "<b>" + k.split('|')[0] + "</b><br />" + v + "<br />";
            //         })
            //         html = html + "</p></div></div></div>";
            //     })
            // }
            $("#jid").val(ret.jid);
            //$("#exec_type").val(ret.is_group);
            $("#accordion").html(html);
            $("#result-modal-salt").modal("show");
        }
    })
}


function result_check(rtype, url) {
    var result_type = $("input[name='result_type']").val();
    var jid=$("#jid").val();
    if(jid==""){
        return false;
    }
    var exec_type=$("#exec_type").val();
    $(".modal-loading").show();
    $.ajax({
        type:"POST",
        url:url,
        data:{jid:jid, "result_type":result_type, "type":rtype},
        dataType:"html",
        success:function (ret) {
            $(".modal-loading").hide();
            var ret = JSON.parse( ret );
            var html = "";
            if(rtype=="exec") {
                $.each(ret, function (i, item) {
                    html = html + "<div class='panel panel-default' style='background:#272822;border:none;'><div><b style='color: #66d9ef'>主机：<a data-toggle='collapse' data-parent='#accordion' href='#" +
                        i.replace(/[.]/g, "") + "' style='color: #66d9ef'>" + i + "</a></b></div><b><div id='" + i.replace(/[.]/g, "")
                        + "' class='panel-collapse collapse'><div><p class='mydashed'>结果：</b><br />" + item + "</p></div></div></div>";
                })
            }else{
                $.each(ret, function(i, item){
                    html = html + "<div class='panel panel-default' style='background:#272822;border:none;'><div><b style='color: #66d9ef'>主机：<a data-toggle='collapse' data-parent='#accordion' href='#" +
                        i.replace(/[.]/g,"") + "' style='color: #66d9ef'>" + i + "</a></b></div><b><div id='" + i.replace(/[.]/g,"")
                        + "' class='panel-collapse collapse'><div><p class='mydashed'>结果：</b><br />";
                    $.each(item, function (k,v) {
                        html = html + "<b>" + k.split('|')[0] + "</b><br />" + v + "<br />";
                    })
                    html = html + "</p></div></div></div>";
                })
            }
            $("#modal-body").html(html);
            $('#result-modal-salt').modal('show');
        },
        errors:function(e){
            alert("error");
        }
    });
}