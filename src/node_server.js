var net = require('net');
var fs = require('fs');
var dateFormat = require('dateformat');

var server = net.createServer(function (connect)
{ //'connection' listener
	
	var now = new Date();
	var milisecond = now.getTime();
	var day = dateFormat(now.request_date, "yyyymmdd-hhMMss-"+milisecond);
	
	//console.log("day : " + day);
	var writeStream = fs.createWriteStream(__dirname + "/" + day + ".txt");
	
	//console.log('Java client connected to this nodeServer');
	connect.on('data', function (data)
    {
        //console.log(data);   
        writeStream.write(data);
    });
	connect.on('end', function ()
    {
        //console.log('nodeServer disconnected');
        writeStream.end();
    });
});
server.listen(6000, function ()
{ //'listening' listener
    console.log('nodeServer listening port:6000');
});
server.on('error', function(ex) {
  console.log("handled error");
  console.log(ex);
});
