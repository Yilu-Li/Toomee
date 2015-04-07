/**
 * Created by liyilu on 2015/4/3.
 */
//function scan_apps(){
//    cordova.exec(function(winParam){document.write("Visits" + winParam + "time(s).");}
//        ,function(error){document.write("Visits" + error + "time(s).");}
//        ,"ScanApps"
//        , "start"
//        ,["firstArgument", "secondArgument", 42, false]);
//
//}

var scan = {
    createEvent:function(successCallback, errorCallback){
        cordova.exec(
            successCallback,
            errorCallback,
            'ScanPlugin',
            'start',
            [{}]
        );
    }
}

//module.exports = scan;