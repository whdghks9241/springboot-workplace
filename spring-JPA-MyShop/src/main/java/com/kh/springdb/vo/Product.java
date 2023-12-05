package com.kh.springdb.vo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // 관계형 sql
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Products")
public class Product {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_name")
//	@SequenceGenerator(name = "product_sequence", sequenceName="PRODUCT_SEQ", allocationSize = 1)

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long product_id;
	@Column(nullable = false, length=50)
	private String product_name;
	@Column(nullable = false, length=50)
	private String category;
	@Column(name="price")
	private Double price;
	private Integer stock_quantity;
}


/*
	@Table: 데이블 이름을 지정
	@Id: 해당 필드가 엔터티의 primaryKey 임을 나타냄
	@Column: 해당 필드가 데이터베이스 테이블의 컬럼에 매핑되는 것을 확인할 수 있음
	
	nullable: 해당 컬럼이 null 값을 허용하는지 여부를 나타냄
	length: 문자열 컬럼에 최대 길이를 지정
	String: 시작되는 필드 값의 경우 String으로 지정된 이름으로 명시되기 떄문에 띠로 name을 지정해주지 않아도 되지만
			String 이외 값은 name을 설정해주어 Column 명을 지정해주는 것이 원칙
			
	@GeneratedValue JPA에서 엔터티의 기본 키 값을 자동으로 생성하는 방법을 지정하는데 사용하는 어노테이션
	시퀀스를 사용해서 기본키 값을 생성할 수 있도록 지원
	시퀀스는 데이터 베이스에서 중복되는 값이 아닌 각 레코드가 고유한 숫자번호를 가질 수 있도록 자동으로 값을 생성해 줌
	@SequenceGenerator = GeneratedValue와 연결할 이름을 설정해주고 시퀀스의 이름과 크기를 지정할 수 있음
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName="PRODUCT_SEQ", allocationSize = 1)
	
	데이터베이스 자체에서 자동으로 값이 증가할 수 있도록 자동생성이 들어 있는 경우 아래 어노테이션 방식을 사용
	새로운 레코드가 삽입될 때 마다 데이터베이스가 자동으로 기본키의 값을 증가시킴
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	Lombok
		@Builder : 객체를 생성할 때 매개변수의 순서나 개수에 관계없이 보기 편할 수 있도록 객체를 생성할 수 있게 도와주는 메서드
		
		@AllArgsContructor : 모든 필드에 생성자를 생성해줌
							 객체를 생성할 때 모든 필드를 포함하는 생성자를 쉽게 만들 수 있음
							 
							 예제코드 :
							 @AllArgsContruuctor
							 public class Student {
							 
							 	private String name; // new Student("학생명", 3); 
							 	private int grade;
							 
							 }
		@NoArgsConstructor : 매개변수가 없는 기본 생성자를 생성해줌
							
							 예제코드 :
							 @NoArgsConstructor
							 public class School {
							 
							 	// new School();
							 
							 }
							 
	JPA 어노테이션
		@Prepersist : 엔터티가 데이터베이스에 저장되기 전에 호출되는 메서드를 지정
					  엔터티에 필요한 사전 처리 작업을 수행하는데 많이 사용

					  예제코드 :
					  @Entity
					  public class TestEntity {
					   		@id
					   		private Long id;
							private String name;
							private Date createDate; // now 라는 메서드를 활용해서 현재시간 기입
							
							@PrePersists
							private void preWork() {
								// 저장 전 수행할 작업을 작성
								// 생성일자 설정, 특정 필드 초기화
							}
							
							@Prepersists
							private void createDate() {
								this.createDate = LocalDate.noew();
							}
							
					  }
 */
 