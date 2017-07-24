
class Product {
	
	private String id;
	private String productCategory;
	
	public Product(String id, String productCategory) {
		super();
		this.id = id;
		this.productCategory = productCategory;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productCategory=" + productCategory + "]";
	}
	
	
}
