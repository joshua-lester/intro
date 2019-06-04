public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date(int year, int month, int day) {
		exception(year, month, day);
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Date() {
		this(1970, 1, 1);
	}
	
	public void setDay(int x) {
		exception(this.year, this.month, x);
		this.day = x;
	}
	
	public void setMonth(int x) {
		exception(this.year, x, this.day);
		this.month = x;
	}
	
	public void setYear(int x) {
		exception(x, this.month, this.day);
		this.year = x;
	}
	
	public void addDays(int days) {
		for (int i = 1; i <= days; i++) {
			this.day++;
			if (this.day == this.daysInMonth()) {
				this.month++;
			}
		}
	}
	
	public void addWeeks(int weeks) {
		for (int i = 1; i <= weeks*7; i++) {
			this.day++;
			if (this.day == this.daysInMonth()) {
				this.month++;
				this.day=0;
			}
		}
	}
	
	public int daysTo(Date other) {
		if (other.year == this.year) {
			if (other.month == this.month) {
				if (other.day == this.day) {
					return 0;
				}
			}
		}
		Date max = new Date(this.max(other).year, this.max(other).month, this.max(other).day);
		Date min = new Date(this.min(other).year, this.min(other).month, this.min(other).day);
		int days = 0;
		while (!min.toString().equals(max.toString())) {
			if (max.day-1 == 0) {
				if (max.month == 1) {
					max.year--;
					max.month = 12;
				} else {
					max.month--;
					max.day = max.daysInMonth();
				}
			} else {
				days++;
				max.day--;
			}
		}
		return days;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public boolean isLeapYear() {
		return (this.year%4 == 0);
	}
	
	public String toString() {
		if (this.month < 10 && this.day < 10) {
			return this.year+"/0"+this.month+"/0"+this.day;
		} else if (this.month >= 10 && this.day <10) {
			return this.year+"/"+this.month+"/0"+this.day;
		} else if (this.month < 10 && this.day >= 10) {
			return this.year+"/0"+this.month+"/"+this.day;
		} else {
			return this.year+"/"+this.month+"/"+this.day;
		}
	}
	
	public static void daysTo(Date one, Date two)	{
		
	}
	
	public String longDate() {
		if (this.month == 1) {
			return "January "+this.day+", "+this.year;
		} else if (this.month == 2) {
			return "February "+this.day+", "+this.year;
		}else if (this.month == 3) {
			return "March "+this.day+", "+this.year;
		}else if (this.month == 4) {
			return "April "+this.day+", "+this.year;
		}else if (this.month == 5) {
			return "May "+this.day+", "+this.year;
		}else if (this.month == 6) {
			return "June "+this.day+", "+this.year;
		}else if (this.month == 7) {
			return "July "+this.day+", "+this.year;
		}else if (this.month == 8) {
			return "August "+this.day+", "+this.year;
		}else if (this.month == 9) {
			return "September "+this.day+", "+this.year;
		}else if (this.month == 10) {
			return "October "+this.day+", "+this.year;
		}else if (this.month == 11) {
			return "November "+this.day+", "+this.year;
		}else {
			return "December "+this.day+", "+this.year;
		}
	}
	
	public void exception(int y, int m, int d) {
		if (m > 12 || d > 31 || d > 30 && 
				(m == 4 || m == 6 || m == 9 || m == 11) ||
				(y%4==0)&&(m==2)&&(d > 29) ||
				(y%4!=0)&&(m==2)&&(d > 28) || y<0 || m<0 || d<0) {
			throw new IllegalArgumentException();
		}
	}
	
	public int daysInMonth() {
		if (this.month == 1) {
			return 31;
		} else if (this.month == 2) {
			if (this.year%4==0) {
				return 29;
			} else {
				return 28;
			}
		}else if (this.month == 3) {
			return 31;
		}else if (this.month == 4) {
			return 30;
		}else if (this.month == 5) {
			return 31;
		}else if (this.month == 6) {
			return 30;
		}else if (this.month == 7) {
			return 31;
		}else if (this.month == 8) {
			return 31;
		}else if (this.month == 9) {
			return 30;
		}else if (this.month == 10) {
			return 31;
		}else if (this.month == 11) {
			return 30;
		}else {
			return 31;
		}
	}
	
	public Date max(Date other) {
		if (other.year - this.year < 0) {
			return this;
		} else if (this.year - other.year < 0) {
			return other;
		} else {
			if (other.month - this.month < 0) {
				return this;
			} else if (this.month - other.month < 0) {
				return other;
			} else {
				if (other.day - this.day < 0) {
					return this;
				} else if (this.day - other.day < 0) {
					return other;
				}
			}
		}
		return other;
	}
	
	public Date min(Date other) {
		if (this.year-other.year < 0) {
			return this;
		} else if (other.year - this.year < 0) {
			return other;
		} else {
			if (this.month-other.month < 0) {
				return this;
			} else if (other.month - this.month < 0) {
				return other;
			} else {
				if (this.day-other.day < 0) {
					return this;
				} else if (other.day-this.day < 0) {
					return other;
				}
			}
		}
		return other;
	}
	
}
