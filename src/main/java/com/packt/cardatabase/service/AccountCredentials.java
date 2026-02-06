package com.packt.cardatabase.service;

// 레코드는 불변의 데이터를 전송할 때 사용
// getter, setter 생성 필요 없음
public record AccountCredentials(String username, String password) {

}
