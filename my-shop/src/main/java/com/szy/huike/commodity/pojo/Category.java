package com.szy.huike.commodity.pojo;

import java.util.List;

public class Category {
	
		private Integer catId;  // 主键
		
		private String catName;  //类别名称
		
		private String catIden;	// 类别当前的地址   是    0

		private Integer parentId;	// 类别的父类id    一层一层嵌套
		  
		private String parentIden;	// 类别的父类地址,   当做id用
		
		private List<Category>	listChild;  //当前类别的子类别集合
		
		///可能暂时没用
		private String catUrl; // 类别url

		
		
		public Integer getCatId() {
			return catId;
		}

		public void setCatId(Integer catId) {
			this.catId = catId;
		}

		public String getCatName() {
			return catName;
		}

		public void setCatName(String catName) {
			this.catName = catName;
		}

		public String getCatIden() {
			return catIden;
		}

		public void setCatIden(String catIden) {
			this.catIden = catIden;
		}

		public Integer getParentId() {
			return parentId;
		}

		public void setParentId(Integer parentId) {
			this.parentId = parentId;
		}

		public String getParentIden() {
			return parentIden;
		}

		public void setParentIden(String parentIden) {
			this.parentIden = parentIden;
		}

		public List<Category> getListChild() {
			return listChild;
		}

		public void setListChild(List<Category> listChild) {
			this.listChild = listChild;
		}

		public String getCatUrl() {
			return catUrl;
		}
		public void setCatUrl(String catUrl) {
			this.catUrl = catUrl;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((catId == null) ? 0 : catId.hashCode());
			result = prime * result + ((catIden == null) ? 0 : catIden.hashCode());
			result = prime * result + ((catName == null) ? 0 : catName.hashCode());
			result = prime * result + ((catUrl == null) ? 0 : catUrl.hashCode());
			result = prime * result + ((listChild == null) ? 0 : listChild.hashCode());
			result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
			result = prime * result + ((parentIden == null) ? 0 : parentIden.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Category other = (Category) obj;
			if (catId == null) {
				if (other.catId != null)
					return false;
			} else if (!catId.equals(other.catId))
				return false;
			if (catIden == null) {
				if (other.catIden != null)
					return false;
			} else if (!catIden.equals(other.catIden))
				return false;
			if (catName == null) {
				if (other.catName != null)
					return false;
			} else if (!catName.equals(other.catName))
				return false;
			if (catUrl == null) {
				if (other.catUrl != null)
					return false;
			} else if (!catUrl.equals(other.catUrl))
				return false;
			if (listChild == null) {
				if (other.listChild != null)
					return false;
			} else if (!listChild.equals(other.listChild))
				return false;
			if (parentId == null) {
				if (other.parentId != null)
					return false;
			} else if (!parentId.equals(other.parentId))
				return false;
			if (parentIden == null) {
				if (other.parentIden != null)
					return false;
			} else if (!parentIden.equals(other.parentIden))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Category [catId=" + catId + ", catName=" + catName + ", catIden=" + catIden + ", parentId="
					+ parentId + ", parentIden=" + parentIden + ", listChild=" + listChild + ", catUrl=" + catUrl + "]";
		}
		
		public Category() {}

}
