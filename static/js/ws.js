        function webshell(id){
            var schema = window.location.protocol=='https:' ? 'wss:' : 'ws:';
            var host =  window.location.host;
            socket = new ReconnectingWebSocket(schema+"//"+ host+"/webshell/" + id + "/");
            socket.onmessage = function(e){
                var msg = JSON.parse(e.data);
                $(msg.html).insertBefore('#insert');
                $('#terminal').scrollTop(10000000000);
            }
            socket.onopen = function() {
                socket.send(JSON.stringify({cmd:''}));
            }
            socket.onclose = function(){
                console.log('disconnected');
            }
            $('#insert').keydown(function(evt){
                var keynum = (evt.keyCode ? evt.keyCode : evt.which);
                if (keynum == 13 || keynum==10){
                    socket.send(JSON.stringify({cmd:$('#insert').val()+'\n'}));
                    $('#insert').val('');
                }
                else if (evt.ctrlKey && keynum>=65){
                    socket.send(JSON.stringify({cmd:$('#insert').val()+String.fromCharCode(keynum-64)}));
                    $('#insert').val('');
                    evt.preventDefault();
                }
                else if (keynum==9){
                    socket.send(JSON.stringify({cmd:$('#insert').val()+'\t'}));
                    $('#insert').val('');
                    evt.preventDefault();
                }
            });
        };