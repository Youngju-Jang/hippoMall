import React, { useState } from "react";
import Title from "../components/Title";
import Button from "../components/Button";

const MainPage = () => {
  const [state, setState] = useState({
    search: "",
    option: "",
  });

  const Search = () => {
    // 검색했을때 링크
  };

  

  return (
    <div id="wrap">
      <div id="sub_container">
        <div id="contentsWrap" className="sub_con5">
          <div className="board_form">
            <Title>상품 등록/보기/수정</Title>

            <div className="contents">
              {/* 헤더 버튼세트 */}
              <div className="btnSet clfix mgb15">
                <span className="fr">
                  <Button>목록</Button>
                  <Button id="addCart">장바구니 추가</Button>
                  <Button href="/product/add">등록 / 수정</Button>
                </span>
              </div>
              {/* 헤더 버튼세트 */}
              {/* 검색라인 */}
              <form method="post" name="search">
                <table className="bbsWrite mgb35">
                  <caption></caption>
                  <colgroup>
                    <col width="95" />
                    <col width="395" />
                    <col width="95" />
                    <col />
                  </colgroup>
                  <tbody>
                    <tr>
                      <th>업체명</th>
                      <td>
                        <select style={{ width: "200px" }}>
                          <option>선택하세요</option>
                        </select>
                      </td>
                      <th>
                        <select
                          id="query"
                          name="query"
                          value={state.option}
                          onChange={(e) => {
                            setState({ ...state, option: e.target.value });
                          }}
                        >
                          <option selected="selected" value="">
                            선택하세요
                          </option>
                          <option value="productName">상품명</option>
                          <option value="productOrigin">원산지</option>
                          <option value="productCategory">카테고리</option>
                        </select>
                      </th>
                      <td>
                        <input
                          value={state.search}
                          onChange={(e) => {
                            setState({ ...state, search: e.target.value });
                          }}
                          type="text"
                          style={{ border: "1px solid #ddd", height: "20px" }}
                          className="inputText"
                          size="30"
                        />
                        <Button onClick={Search}>검색</Button>
                        <Button href="/product" id="reset">
                          새로고침
                        </Button>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </form>
              {/* 검색라인 */}
              {/* 리스트 본문 */}
              <form
                action="${pageContext.request.contextPath}/cart/add"
                method="post"
                name="addCart"
              >
                <table className="bbsList">
                  <colgroup>
                    <col width="80" />
                    <col width="80" />
                    <col width="170" />
                    <col width="170" />
                    <col width="170" />
                    <col width="170" />
                    <col width="170" />
                    <col width="170" />
                    <col width="170" />
                  </colgroup>
                  <thead>
                    <tr>
                      <th scope="col">장바구니</th>
                      <th scope="col">NO.</th>
                      <th scope="col">상품명</th>
                      <th scope="col">이미지</th>
                      <th scope="col">원산지</th>
                      <th scope="col">가격</th>
                      <th scope="col">종류</th>
                      <th scope="col">날짜</th>
                      <th scope="col">판매자</th>
                    </tr>
                  </thead>

                  <tbody id="dataRows">
                    {/* <c:forEach items="${productList}" var="cart" varStatus="i">
                      <tr>
                        <td>
                          <input type="checkbox" name="newCartIntSet" value="${cart.no}" />
                        </td>
                        <td>${cart.no}</td>
                        <td>
                          <a href="/product/${cart.no}">${cart.productName}</a>
                        </td>
                        <c:choose>
                          <c:when test="${not empty cart.fileName}">
                            <td>
                              <img
                                src="${pageContext.request.contextPath}/resources/downImage/${cart.fileName}"
                                width="50"
                                height="50"
                              />
                            </td>
                          </c:when>
                          <c:otherwise>
                            <td></td>
                          </c:otherwise>
                        </c:choose>
                        <td>${cart.productOrigin}</td>
                        <td>${cart.productPrice}</td>
                        <td>${cart.productCategory}</td>
                        <td>${cart.regdate}</td>
                        <td>${cart.seller}</td>
                      </tr>
                    </c:forEach> */}
                  </tbody>
                </table>
              </form>
              {/* 리스트 본문 */}
              <br />
              <Button id="showMore">더보기</Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MainPage;
