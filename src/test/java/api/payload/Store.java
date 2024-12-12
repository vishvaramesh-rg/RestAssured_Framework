package api.payload;

import com.github.javafaker.IdNumber;

public class Store {
	
	
//	    "id": 9223372036854774055,
//	    "petId": 0,
//	    "quantity": 0,
//	    "shipDate": "2024-12-12T10:42:08.082+0000",
//	    "status": "placed",
//	    "complete": true
		
		String id;
		int petId;
		int quantity;
		String shipDate;
		String status;
		Boolean complete;
		
		public String getId() {
			return id;
		}
		public String setId(String string) {
			return this.id = string;
		}
		
		public int getPetId() {
			return petId;
		}
		public void setPetId(int petId) {
			this.petId = petId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getShipDate() {
			return shipDate;
		}
		public void setShipDate(String shipDate) {
			this.shipDate = shipDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Boolean getComplete() {
			return complete;
		}
		public void setComplete(Boolean complete) {
			this.complete = complete;
		}
		
	    
	    

}
