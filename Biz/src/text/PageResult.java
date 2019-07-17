
package text;
import java.util.List;

public class PageResult {
	private List<Object> list;   //对象数组
	private List<Object> currentlist;   //对象数组
	private Integer firstPage=1;   //首页
	private Integer prePage;     //上一页
	private Integer currentPage=1; //当前页
	private Integer nextPage;    //下一页
	private Integer totalPage;   //尾页(总页数)
	private Integer totalItems;  //总条数
	private Integer  pageItem=10;   //每一页条数，默认10 
	
	public List<Object> getCurrentlist(){
		return currentlist;
	}
	public void setCurrentlist(){
		this.currentlist = list.subList((currentPage-1)*pageItem, ((currentPage-1)*pageItem+pageItem)>totalItems?totalItems: ((currentPage-1)*pageItem+pageItem));
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Integer getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}
	public Integer getPrePage() {
		return currentPage-1<=0?1:currentPage-1;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getNextPage() {
		return currentPage+1>=this.getTotalPage()?this.getTotalPage():currentPage+1;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getTotalPage() {
		return totalItems%pageItem!=0?totalItems/pageItem+1:totalItems/pageItem;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
		this.totalPage=totalItems/pageItem+1;
	}
	public Integer getPageItem() {
		return pageItem;
	}
	public void setPageItem(Integer pageItem) {
		this.pageItem = pageItem;
	}
	
}