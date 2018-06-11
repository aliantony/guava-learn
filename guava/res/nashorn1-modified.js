// **********************************************//
// 公安案件信息 客户端脚本
// 
// @author wangqian
// @date 2018-05-23
// @id f83808f5168479579f82a1964123b8c0
// **********************************************//
/**
 * onLoadClient(formb7ccd)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function formb7ccd_onLoadClient (rc){
    dealDisable('jqInputJson', 'jqHiddenJsonZc');
}
/**
 * onClickClient(jqButtonSaveAjzcxx)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtonSaveAjzcxx_onClickClient (rc){
    Artery.get("jqFormAreaAjzc").submit(function(){
        Artery.showSuccess("保存成功");
    });
}


/**
 * onClickClient(jqLinkdeletezjxx)
 * 
 * @param  rc 系统提供的AJAX调用对象
 * @param  {rs4.CId}
 */
function jqLinkdeletezjxx_onClickClient (rc, ywid){
    executeDelete(rc, ywid, "jqGridZjxx");
}

/**
 * 删除公用逻辑
 */
function executeDelete(rc, id, listId) {
    Artery.confirmMsg('提示', '确认删除该条记录', function(btn) {
                if (btn == "yes") {
                    rc.put("id", id);
                    rc.send(function(result) {
                                Artery.get(listId).reload();
                                Artery.showSuccess("删除成功");
                            });
                }

            });
}
/**
 * onClickClient(jqLinkDeleteTbxx)
 * 
 * @param  rc 系统提供的AJAX调用对象
 * @param {rs3.CId}
 */
function jqLinkDeleteTbxx_onClickClient (rc, ywid){
    executeDelete(rc, ywid, "jqGridAjtbxx");
}
/**
 * onClickClient(jqLinkdeletexyr)
 * 
 * @param  rc 系统提供的AJAX调用对象
 * @param {rs5.CId}
 */
function jqLinkdeletexyr_onClickClient (rc, ywid){
    executeDelete(rc, ywid, "jqGridXyr");
}
/**
 * onClickClient(jqLinkdeletebhr)
 * 
 * @param  rc 系统提供的AJAX调用对象
 * @param {rs6.CId}
 */
function jqLinkdeletebhr_onClickClient (rc, ywid){
    executeDelete(rc, ywid, "jqGridBgr");
}

print('foobar');
