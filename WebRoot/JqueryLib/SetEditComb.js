/*
author: 
qq: 
*/
function GetEvent()
{
    if(document.all)
    {
        return window.event;
    }
    
  func = GetEvent.caller; 
    while(func != null)
    {
        var arg0 = func.arguments[0];
    if(arg0)
    {
        if((arg0.constructor == Event || arg0.constructor == MouseEvent)
            || (typeof(arg0) == "object" && arg0.preventDefault && arg0.stopPropagation))
        {
            return arg0;
        }
    }
    
    func=func.caller;
  }
  
  return null;
}

function getAbsoluteCoords (e) {
  var t = e.offsetTop; 
  var l = e.offsetLeft; 
  var w = e.offsetWidth; 
  var h = e.offsetHeight;
  while(e = e.offsetParent) 
  {
      t += e.offsetTop; 
      l += e.offsetLeft; 
  };
   
  return { top: t, left: l, width: w, height: h, bottom: t + h, right: l + w };
}
function OptionItem(strText, strValue, nOptionIndex)
{ 
    OptionItem.prototype.Active = function(bActive)
    {
        if(bActive)
        {
            var item = document.getElementById(this.domInstanceId);
            item.style.fontWeight = "bold";
            item.style.backgroundColor = "#3366cc";
            item = null;
        }
        else
        {
            // 若选中状态则返回

            if(this.selected)
            {
                //return;

            }
            var item = document.getElementById(this.domInstanceId);
            item.style.fontWeight = "normal";
            item.style.backgroundColor = "#ffffff";
            item = null;
        }
    };
    OptionItem.prototype.ScrollIntoView = function(bTop)
    {
        document.getElementById(this.domInstanceId).scrollIntoView(bTop);
    }
    OptionItem.prototype.Initialize = function(strText, strValue, nOptionIndex)
    {
        this.parentInstance = null;
        this.selected = false;
        this.optionIndex = nOptionIndex;
        this.text = strText;
        this.value = strValue;
        this.domInstanceId = OptionItem.prefixId + OptionItem.index;
        OptionItem.index ++;
        var divItem = document.createElement("DIV");
        divItem.instance = this;
        with(divItem)
        {
            // 设置ID

            id = this.domInstanceId;
            // 设置text

            innerHTML = this.text;
            // 设置鼠标样式

            style.cursor = "default";
            style.fontSize = "13px";
        };
        divItem.onmouseover = function()
        {
            // this.style.fontWeight = "bold";

            this.instance.OnMouseOver();
        };
        divItem.onmouseout = function()
        {
            this.instance.OnMouseOut();
            return false;
        };
        OptionItem.prototype.OnMouseOut = function()
        {
            this.Active(false);
        };
        divItem.test = function(evt)
        {
            
        };
        
        divItem.onmousedown = function()
        {
            this.instance.OnMouseDown();
            return false;
        };
        
        OptionItem.prototype.OnMouseOver = function()
        {
            this.Active(true);
        };
        
        OptionItem.prototype.OnMouseDown = function()
        {
            this.parentInstance.OnItemClick(this.optionIndex);
        };
        
        OptionItem.prototype.Show = function()
        {
            var domInstance = document.getElementById(this.domInstanceId);
            if(domInstance)
            {
                with(domInstance)
                {
                    style.display = "block";
                    style.visibility = "visibile";
                }
            }
        };
        
        OptionItem.prototype.Hide = function()
        {
            var domInstance = document.getElementById(this.domInstanceId);
            if(domInstance)
            {
                with(domInstance)
                {
                    style.display = "none";
                    style.visibility = "hidden";
                }
            }
        };
        
        OptionItem.prototype.Test = function()
        {
            return true;
        };
        
        OptionItem.prototype.GetDomInstance = function()
        {
            var domInstance = document.getElementById(this.domInstanceId);
            if(domInstance)
            {
                return domInstance;
            }
            else
            {
                return null;
            }
        };
        
        OptionItem.prototype.SetParentInstance = function(parentInstance)
        {
            this.parentInstance = parentInstance;
        };
        
        // 初始化

        document.body.insertBefore(divItem, null);
    };
    
    OptionItem.prototype.GetId = function()
    {
        return this.domInstanceId;
    };

    this.Initialize(strText, strValue, nOptionIndex);
}
// id 前缀

OptionItem.prefixId = "optionItem";
// 计数

OptionItem.index = 0;
// 列表类

function OptionList(txtInstance,itemCount)
{
    OptionList.prototype.Initialize = function(txtInstance)
    {
        var txtDomInstance = document.getElementById(txtInstance.domInstanceId);
        if(!txtDomInstance)
        {
            window.alert("错误！");
            return false;
        }
        this.visible = false;
        this.selectedIndex = -1; // 没有选中条目

        this.txtInstance = txtInstance;
        var ret = getAbsoluteCoords(txtDomInstance);
        this.left = ret.left;
        this.top = ret.top + ret.height;
        this.width = ret.width;
		var hei=100;
		if(itemCount<6)
		{
			hei= itemCount*15;
		}
        this.height = ""+hei;
        this.itemArray = new Array();
        this.domInstanceId = OptionList.prefixId + OptionList.index;
        OptionList.index ++;
        var divList = document.createElement("DIV");
        divList.instance = this;
        with(divList)
        {
            id = this.domInstanceId;
            style.position = "absolute";
            style.top = this.top; + "px";
            style.zIndex = "9999";
            style.left = this.left + "px";
            style.display = "none";
            style.visibility = "hidden";
            style.backgroundColor = "#ffffff";
            style.border = "1px";
            style.borderStyle = "solid";
            style.overflowY = "auto";
            style.width = this.width + "px";;
            style.height = this.height + "px";;
        }
        divList.onfocus = function()
        {
            this.instance.Show();
            document.getElementById(AutoSelect.prefixId+AutoSelect.index).focus();
        };
        
        // 添加到body中

        document.body.insertBefore(divList, null);
    };
    
    OptionList.prototype.SetLeft = function(nLeft)
    {
        this.left = nLeft;
    };
    OptionList.prototype.SetTop = function(nTop)
    {
        this.top = nTop;
    };
    
    OptionList.prototype.SetWidth = function(nWidth)
    {
        this.width = nWidth;
    };
    
    OptionList.prototype.SetHieght = function(nHeight)
    {
        this.height = nHeight;
    };
    // 添加Item

    OptionList.prototype.AddItem = function(strText, strValue)
    {
        var divItem = new OptionItem(strText, strValue, this.itemArray.length);
        divItem.SetParentInstance(this);
        var divList = document.getElementById(this.domInstanceId);
        divList.insertBefore(document.getElementById(divItem.GetId()), null);
        this.itemArray.push(divItem);
    };
    
    // 显示

    OptionList.prototype.Show = function()
    {
        this.visible = true;
        var divList = document.getElementById(this.domInstanceId);
        divList.style.display = "block";
        divList.style.visibility = "visible";
        divList.style.top = this.top + "px";
        divList.style.left = this.left + "px";
        divList.style.width = this.width + "px";
        divList.style.height = this.height + "px";
        this.itemArray[this.selectedIndex].Active(true);
        this.itemArray[this.selectedIndex].ScrollIntoView(false);
    };
    
    OptionList.prototype.OnItemClick = function(optionIndex)
    {
        this.SetSelectedIndex(optionIndex);
        this.txtInstance.OnItemClick(optionIndex);
        this.Hide();
        var txtDomInstance = document.getElementById(this.txtDomInstanceId);
    };
    // 隐藏

    OptionList.prototype.Hide = function()
    {
        this.visible = false;
        var divList = document.getElementById(this.domInstanceId);
        divList.style.display = "none";
        divList.style.visibility = "hidden";
    };
    
    OptionList.prototype.SetSelectedIndex = function(selectedIndex)
    {
        if(selectedIndex == this.selectedIndex)
        {
            return;
        }
        if(selectedIndex < 0)
        {
            selectedIndex = 0;
        }
        if(selectedIndex >= this.itemArray.length)
        {
            selectedIndex = this.itemArray.length - 1;
        }

        var txtDomInstance = document.getElementById(this.txtInstance.domInstanceId);
        if(txtDomInstance)
        {
            txtDomInstance.value = this.itemArray[selectedIndex].text;
            if(this.selectedIndex >= 0 && this.selectedIndex < this.itemArray.length)
            {
                this.itemArray[this.selectedIndex].selected = false;
                this.itemArray[this.selectedIndex].Active(false);
            }
            this.selectedIndex = selectedIndex;
            this.itemArray[this.selectedIndex].Active(true);
            this.itemArray[this.selectedIndex].selected = true;
            this.itemArray[this.selectedIndex].ScrollIntoView(false);
        }
    };
    
    OptionList.prototype.GetSelectedIndex = function()
    {
        return this.selectedIndex;
    };
    OptionList.prototype.GetDomInstance = function()
    {
        return document.getElementById(this.domInstanceId);
    };
    
    this.Initialize(txtInstance);
}
// ID前缀

OptionList.prefixId = "divOptionList";
// 计数

OptionList.index = 0;

// 文本框类

function AutoSelect(sltId,wid)
{
    AutoSelect.prototype.OnItemClick = function(optionIndex)
    {
        document.getElementById(this.domInstanceId).value = document.getElementById(this.sourceSlt).options[optionIndex].text;
        document.getElementById(this.sourceSlt).selectedIndex = optionIndex;
    };
    AutoSelect.prototype.Initialize = function()
    {
        // 保存selectID

        this.sourceSlt = sltId;
        // 获取Select 并隐藏

        var slt = document.getElementById(sltId);
        slt.style.display = "none";
        slt.style.visibility = "hidden";
        
        
        
        this.domInstanceId = AutoSelect.prefixId + AutoSelect.index;
        // 计数加一

        AutoSelect.index ++;
        
        // 创建文本框

        var ret = getAbsoluteCoords(slt);


        var txtAutoSelect = document.createElement("INPUT");

        txtAutoSelect.instance = this;
        with(txtAutoSelect)
        {
            type = "text";
            id = this.domInstanceId;
            // style.color = "#999999";

            style.cursor = "default";
            style.border = "1px";
            style.borderColor = "#84a1bd";
            style.borderStyle = "solid";
            style.autocomplete = "off";
            style.padding = "2px";
            style.width = wid+"px";
        }
        //var wid = "500px"
        //this.width="500px";
        txtAutoSelect.onblur = function()
        {
            this.instance.OnBlur();
        };
    
        txtAutoSelect.onkeydown = function()
        {
            var e = GetEvent();
            this.instance.OnKeyDown(e);
            e = null;
        };
        AutoSelect.prototype.OnKeyDown = function(e)
        {
            switch(e.keyCode)
            {
                case 27: // ESC

                    this.optionList.Hide();
                    break;
                case 40: // 向下键

                    if(!this.optionList.visible)
                    {
                        this.optionList.Show();
                    }
                    else
                    {
                        this.optionList.SetSelectedIndex(this.optionList.GetSelectedIndex() + 1);
                    }
                    break;
                case 38: // 向上键

                    if(this.optionList.visible)
                    {
                        this.optionList.SetSelectedIndex(this.optionList.GetSelectedIndex() - 1);
                    }
                    break;
                case 13: // 回车

                    if(this.optionList.visible)
                    {
                        this.optionList.Hide();
                    }
                default:
                    // window.alert(e.keyCode);

                    break;
            }
        };
        txtAutoSelect.onmousedown = function()
        {
            this.focus();
            this.instance.OnMouseDown();
            return false;
        };
        AutoSelect.prototype.OnMouseDown = function()
        {
            if(!this.optionList.visible)
            {
                this.optionList.Show();
            }
            else
            {
                this.optionList.Hide();
            }
        };
        
        txtAutoSelect.onmousewheel = function()
        {
            var e = GetEvent();
            if(e == null)
            {
                return false;
            }
            this.instance.OnMouseWheel(e);
            e = null;
        };
        AutoSelect.prototype.OnMouseWheel = function(e)
        {
            if(e.wheelDelta <= 0 || e.detail > 0) 
            { 
                this.optionList.SetSelectedIndex(this.optionList.GetSelectedIndex() + 1);
            } 
            else 
            { 
                this.optionList.SetSelectedIndex(this.optionList.GetSelectedIndex() - 1);
            } 
        };

        if(document.body.addEventListener)
        {
            txtAutoSelect.addEventListener("DOMMouseScroll", txtAutoSelect.onmousewheel, false);
        }
        // 将文本框插入到select的位置

        var parentNode = slt.parentNode;
        if(parentNode)
        {
            parentNode.insertBefore(txtAutoSelect, slt);
        }
        else
        {
            // 
			alert("insert error");
        }
        
        txtAutoSelect = null;
        
        // 创建OptionList对象
		var itemCount = slt.options.length;
		
        this.optionList = new OptionList(this,itemCount);
        // 添加optionitem

        
        for(var i = 0; i < itemCount; i ++)
        {
            this.optionList.AddItem(slt.options[i].text, slt.options[i].value);
        }
        // 设置默认选中项

        this.optionList.SetSelectedIndex(slt.selectedIndex);
    };
    
    AutoSelect.prototype.OnBlur = function()
    {
        this.optionList.Hide();
    };
    
    this.Initialize();
}
AutoSelect.prefixId = "AutoSelect";
AutoSelect.index = 0;

function SetAutoSelect(sltId,wid)
{
    var slt = document.getElementById(sltId);
    if(!slt || slt.nodeName != "SELECT")
    {
        window.alert("illegle Object！");
        return;
    }
    slt.instance = new AutoSelect(sltId,wid);
}