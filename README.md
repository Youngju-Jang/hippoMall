# hipponMall - 수정중
3개월차 개인플젝과제

# 공통 설정
* JDK 는 Java11 or Java12를 사용한다.
* `Spring Legacy` 설정 or `SpringBoot` 설정을 사용한다(SpringBoot로 설정할 것을 권장)
  
  * `JAR` 로 빌드한다.
* 영속성 프레임워크는 `MyBatis`를 사용한다.
* DB는 `MySQL`을 사용한다. (bitdb를 이용)

# ShopAPI 서버의 기본정보
* ShopAPI 서버가 다루는 기본 데이터는 아래의 링크를 참조합니다.
  
  * [DB 설계도](https://www.erdcloud.com/d/K9RYjRCppvC6KCrK3) 개인에 알맞게 세팅해서 사용.

# 요구사항
## 1. 회원 `Member`
* [ ]  회원가입 - `/user/signup`  
  * 이름, 비밀번호를 입력하여 회원가입 할 수 있다.
  * `판매자 여부`를 선택할 수 있다.

* [ ]  로그인 - `/user/login`  
  * (이름, 비밀번호)를 입력하여 로그인 할 수 있다.
  * 아이디 저장여부를 선택할 수 있다.

* [ ]  로그아웃 - `/user/logout`
  * `회원`은 로그아웃 할 수 있다.

* [ ]  마이페이지 - `/user/mypage`
  * `로그인`한 회원은 마이페이지를 사용할 수 있다.
  * 스크랩 정보(찜 정보)를 볼 수 있다.

* [ ]  장바구니 - `/user/cart`
  * `로그인` 한 회원은 장바구니를 사용할 수 있다.
  * 장바구니에는 제품의 이미지, 이름, 가격 등의 정보를 표시해야 한다.
  * `회원`은 장바구니 내의 상품 `수량을 조정`하거나 상품을 `삭제`할 수 있다.

## 2. 상품 `Product`
* [ ]  상품등록 - `/product/add`
  * `판매자`는 상품 판매를 위한 상품을 등록할 수 있다.
  * `상품`은 이미지, 이름, 가격, 판매자 등의 정보를 포함해야한다.

* [ ] 상품전체조회 - `/product`
  * `회원`은 상품 전체목록페이지를 확인할 수 있다.
  * `회원`은 상품 `카테고리`, `원산지` 또는 `상품명`을 검색어로 필터링하여 `상품`을 찾을 수 있다.
  * `더보기`버튼을 통한 페이징기능이 있다.

* [ ]  상품조회 - `/product/{productNo}/view`
  * `회원`은 상품 상세페이지를 확인할 수 있다.
  * `회원`은 상품의 설명, 상세 사양, 상품 리뷰 등의 정보를 볼 수 있다.
  * `회원`은 상품 상세페이지내의 상품 리뷰를 등록할 수 있다.
  * 

* [ ]  상품수정 - `/product/edit/{productNo}`
  * `판매자`는 제품을 수정할 수 있다.
  * 상품의 `파일이름`이 없는 경우 기존의 파일명을 유지하도록 한다.
  *  

* [ ]  상품삭제 - `/product/delete/{productNo}`
  


> base : bunsung92's readme [link](https://github.com/orgs/cs-collections/discussions/169#discussion-5260153)

