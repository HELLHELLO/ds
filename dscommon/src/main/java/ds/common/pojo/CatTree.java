package ds.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class CatTree {
    private Object cat;     //分类的根节点
    private List<CatTree> children;     //该分类下的子分类

    public CatTree(Object cat){     //创建时仅初始化根节点，之后根据根节点查找子分类时再设置children
        this.cat=cat;
        this.children=null;
    }

    public void setCat(Object cat) {
        this.cat = cat;
    }

    public void setChildren(List<CatTree> children) {
        this.children = children;
    }

    public Object getCat() {
        return cat;
    }

    public List<CatTree> getChildren() {
        return children;
    }
}
