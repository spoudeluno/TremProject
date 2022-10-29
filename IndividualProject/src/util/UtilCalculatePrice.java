package util;

public class UtilCalculatePrice {
	
	
	
	public UtilCalculatePrice() {
		
	}
	
	public void CalculatePrice(Integer tripDays)
	{
		Integer price = UtilDB.listTripPrice(tripDays - 1).get(0).getPrice();
		calculateFive(price);
		calculateFour(price);
		calculatethree(price);
	}

	public Integer fiveStarHotel;
	
	public Integer fourStarHotel;
	
	public Integer threeStarHotel;

	public Integer getFiveStarHotel() {
		return fiveStarHotel;
	}

	public void setFiveStarHotel(Integer fiveStarHotel) {
		this.fiveStarHotel = fiveStarHotel;
	}

	public Integer getFourStarHotel() {
		return fourStarHotel;
	}

	public void setFourStarHotel(Integer fourStarHotel) {
		this.fourStarHotel = fourStarHotel;
	}

	public Integer getThreeStarHotel() {
		return threeStarHotel;
	}

	public void setThreeStarHotel(Integer threeStarHotel) {
		this.threeStarHotel = threeStarHotel;
	}
	
	private void calculateFive(Integer price)
	{
		Integer total = 0;
		Integer rate = UtilDB.listHotelRate("Five").get(0).getPrice();
		total = price + (rate * 3);
		setFiveStarHotel(total);
		
	}
	
	private void calculateFour(Integer price)
	{
		Integer total = 0;
		Integer rate = UtilDB.listHotelRate("Four").get(0).getPrice();
		total = price + (rate * 3);
		setFourStarHotel(total);
	}
	private void calculatethree(Integer price)
	{
		Integer total = 0;
		Integer rate = UtilDB.listHotelRate("Three").get(0).getPrice();
		total = price + (rate * 3);
		setThreeStarHotel(total);
	}

}
