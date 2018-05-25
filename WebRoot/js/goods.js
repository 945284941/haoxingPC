function changetab(appraiseType) {
    $("#appraiseType").val(appraiseType);
    var url="indexGoodsAction!gainGoodsAppraise.action";
    $.ajax({
        type:"POST",
        url:url,
        cache:true,
        async:true,
        data : $('#pagerForm').serialize(),
        success:function (html) {
            $("#pageReload").html(html);
        }
    });
}


function subCom(){
    $("#carPartsProducerId").val("");
    $("#comForm").submit();
}
function changeUl(tab, htab) {
    $("#" + tab).show();
    $("#" + htab).hide();

}
function goCompanyFenlei(carPId) {
    $("#carPartsProducerId").val(carPId);
    $("#name").val("");
    $("#minMoney").val("");
    $("#maxMoney").val("");
    $("#comForm").submit();
}
$(function () {
    $('.inactive').click(function () {
        if ($(this).siblings('ul').css('display') == 'none') {
            $(this).parent('li').siblings('li').removeClass('inactives');
            $(this).addClass('inactives');
            $(this).siblings('ul').slideDown(100).children('li');
            if ($(this).parents('li').siblings('li').children('ul').css('display') == 'block') {
                $(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
                $(this).parents('li').siblings('li').children('ul').slideUp(100);

            }
        } else {
            //控制自身变成+号
            $(this).removeClass('inactives');
            //控制自身菜单下子菜单隐藏
            $(this).siblings('ul').slideUp(100);
            //控制自身子菜单变成+号
            $(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
            //控制自身菜单下子菜单隐藏
            $(this).siblings('ul').children('li').children('ul').slideUp(100);

            //控制同级菜单只保持一个是展开的（-号显示）
            $(this).siblings('ul').children('li').children('a').removeClass('inactives');
        }
    })
});

// 把组合的key放入结果集SKUResult
function add2SKUResult(combArrItem, sku) {
    var key = combArrItem.join(";");
    if (SKUResult[key]) {// SKU信息key属性
        var ccc = sku["count"] || sku[" count"];
        SKUResult[key].count += ccc;
        SKUResult[key].prices.push(sku.price);
        // 设置选中规格的单品ID
        SKUResult[key].itemId += ";" + sku.itemId;
    } else {
        var ccc = sku["count"] || sku[" count"];
        SKUResult[key] = {
            count : ccc,
            prices : [sku.price],
            itemId : sku.itemId
        };
        console.info(key);
        console.info(SKUResult[key]);
    }
}

// 初始化得到结果集
function initSKU() {
    var i, j, skuKeys = getObjKeys(data);
    for (i = 0; i < skuKeys.length; i++) {
        var skuKey = skuKeys[i];// 一条SKU信息key
        var sku = data[skuKey]; // 一条SKU信息value
        var ccc = sku["count"] || sku[" count"];
        // 剔除库存为0的单品,使之不可选
        if (ccc == 0) {
            continue;
        }
        var skuKeyAttrs = skuKey.split(";"); // SKU信息key属性值数组
        skuKeyAttrs.sort(function(value1, value2) {
            return parseInt(value1) - parseInt(value2);
        });

        // 对每个SKU信息key属性值进行拆分组合
        var combArr = combInArray(skuKeyAttrs);
        for (j = 0; j < combArr.length; j++) {
            add2SKUResult(combArr[j], sku);
        }
        // 结果集接放入SKUResult
        SKUResult[skuKeyAttrs.join(";")] = {
            count : ccc,
            prices : [sku.price],
            itemId : sku.itemId
        };
    }
}


/**
 * 从数组中生成指定长度的组合 方法: 先生成[0,1...]形式的数组, 然后根据0,1从原数组取元素，得到组合数组
 */
function combInArray(aData) {
    if (!aData || !aData.length) {
        return [];
    }

    var len = aData.length;
    var aResult = [];

    for (var n = 1; n < len; n++) {
        var aaFlags = getCombFlags(len, n);
        while (aaFlags.length) {
            var aFlag = aaFlags.shift();
            var aComb = [];
            for (var i = 0; i < len; i++) {
                aFlag[i] && aComb.push(aData[i]);
            }
            aResult.push(aComb);
        }
    }

    return aResult;
}

/**
 * 得到从 m 元素中取 n 元素的所有组合 结果为[0,1...]形式的数组, 1表示选中，0表示不选
 */
function getCombFlags(m, n) {
    if (!n || n < 1) {
        return [];
    }

    var aResult = [];
    var aFlag = [];
    var bNext = true;
    var i, j, iCnt1;

    for (i = 0; i < m; i++) {
        aFlag[i] = i < n ? 1 : 0;
    }

    aResult.push(aFlag.concat());

    while (bNext) {
        iCnt1 = 0;
        for (i = 0; i < m - 1; i++) {
            if (aFlag[i] == 1 && aFlag[i + 1] == 0) {
                for (j = 0; j < i; j++) {
                    aFlag[j] = j < iCnt1 ? 1 : 0;
                }
                aFlag[i] = 0;
                aFlag[i + 1] = 1;
                var aTmp = aFlag.concat();
                aResult.push(aTmp);
                if (aTmp.slice(-n).join("").indexOf('0') == -1) {
                    bNext = false;
                }
                break;
            }
            aFlag[i] == 1 && iCnt1++;
        }
    }
    return aResult;
}

var arr = document.getElementsByClassName("radiogrounp");
var t = $("#appraiseType").val();
$(function () {
    if (null == t) {
        $("#comtab01").attr("checked", true);
        $("#appraiseType").val("1");
    } else {
        for (var i = 1; i < arr.length + 1; i++) {
            if (i == parseInt(t)) {
                $("#comtab0" + i).attr("checked", true);
            } else {
                $("#comtab0" + i).attr("checked", false);
            }
        }
    }
});