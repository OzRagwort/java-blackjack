🚗 상속, interface - 연료 주입

- [x] 자동차 인터페이스를 만든다.

- [x] 주입해야 할 연료량 구하는 기능 추가

- [x] 자동차 정보 반환 기능 추가
  - [x] 연비 반환
  - [x] 여행 거리 반환 
  - [x] 차종의 이름 반환
  
- [x] 렌트 회사 기능
  - [x] 자동차 추가 기능
  - [x] 리포트 반환 기능 

- [x] 중복 제거를 위해 추상 클래스 추가

<br>

# 🃏 블랙잭
- [x] 유저 이름 입력 받기
  - [x] 이름 입력의 앞뒤 공백을 제거한다.
  - [x] 공백 이름은 생성할 수 없다.
- [x] 카드 분배 기능
  - [x] 1장 랜덤 분배
  - [x] 2장 랜덤 분배
- [x] 모든 카드 생성기능 (52장)
  - [x] 모든 플레이어가 공유하는 카드 뭉치 생성
  - [x] 카드 셔플
- [x] 카드 결과 반환 기능
  - [x] 상황에 유리하게 ACE가 1 또는 11로 선택된다.
    - [x] ACE를 11로 봤을 때, 카드 숫자의 총 합이 21이하이면, ACE를 11로 설정한다.  
- [x] 카드 뽑기 기능
  - [x] 유저는 갖고있는 카드들의 숫자 총 합이 21 이하일 때만 뽑을 수 있다.
  - [x] 유저는 갖고있는 카드들의 숫자 총 합이 21 초과일 경우 뽑을 수 없다.
  - [x] 딜러는 갖고있는 카드들의 숫자 총 합이 17이상이 될 때 까지 카드를 계속 뽑는다.
- [x] 유저 입력에 따라서 카드를 뽑을지, 뽑지 않을지 판단한다.
  - [x] n을 입력한 경우, 더 이상 카드를 뽑을지 질문하지 않는다.
  - [x] y 또는 n을 제외한 문자를 입력한 경우, 예외를 발생시킨다.
- [x] 게임 최종 결과 반환 기능
  - [x] 각 모든 유저들은 딜러와 카드를 비교하여 승패를 판단한다.
- [x] 딜러의 카드 출력 방식 구분 기능
  - [x] 처음 카드들 출력 시, 한 장만 보여준다.
  - [x] 최종 카드들 출력 시, 모든 카드들을 보여준다.
  - [x] 전략패턴을 적용한다.
- [x] 승패 판단
  - [x] 첫 두 장의 카드의 합이 21일 때만 블랙잭이다.
  - [x] 유저가 버스트다 : 유저는 무조건 패배이다.
  - [x] 딜러가 버스트다 : 버스트 되지 않은 유저는 모두 승리한다.
  - [x] 유저와 딜러가 모두 블랙잭이면, 비긴다.
  - [x] 둘 중 하나만 블랙잭이면, 블랙잭인 사람이 이긴다.
  - [x] 둘 다 블랙잭도, 버스트도 아니면, 카드 총 합이 큰 사람이 이긴다.
    - [x] 같으면, 비긴다.
- [ ] 배팅 금액 입력받기
  - [ ] 각 유저로부터 배팅 금액을 입력받는다.
  - [x] 배팅 금액이 1000원 이상, 1억원 이하가 아니면, 예외를 발생시킨다.
- [x] 수익 계산
  - [x] 유저 기준
    - [x] 지면, 배팅 금액을 잃는다.
      - [x] 버스트인 경우
      - [x] 유저와 딜러가 버스트가 아닌 상태
        - [x] 유저가 블랙잭이 아니고, 딜러가 블랙잭일 때
        - [x] 카드 총 합이 딜러가 더 클 때
    - [x] 비기면, 돈은 변화가 없다.
      - [x] 유저와 딜러 모두 블랙잭인 경우
      - [x] 유저와 딜러 모두 블랙잭이 아닌 경우
        - [x] 카드 총 합이 같은 경우
    - [x] 블랙잭으로 이기면, 배팅한 금액의 1.5배 만큼을 추가로 받는다.
      - [x] 유저가 블랙잭이고, 딜러가 블랙잭이 아닌 경우
    - [x] 블랙잭이 아닌 상태로 이기면, 배팅한 금액 만큼을 추가로 받는다.
      - [x] 유저가 버스트와 블랙잭이 아닌 상태
        - [x] 딜러가 버스트인 경우
        - [x] 카드 총 합이 유저가 더 클 때
  - [ ] 딜러 기준
    - [ ] 모든 유저들의 수익의 합에 -1을 곱한 값이 수익이 된다.