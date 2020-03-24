# java-chess
체스 게임 구현을 위한 저장소

# 체스 게임 - 콘솔
- 명령어 'start'를 입력한 경우 체스 게임을 시작한다.

- 좌표 2개를 입력

    - [예외처리] 두 좌표가 체스보드 내에 없는 경우
    - [예외처리] 두번째 좌표에 같은 색의 체스 말이 있는 경우
    - [예외처리] 첫번째 좌표에 자신의 체스 말이 없는 경우
    - [예외처리] 규칙에 어긋난 이동을 하는 경우
    - [예외처리] 입력 형식이 잘못된 경우
- 첫번째 좌표의 체스 말을 두번째 좌표로 옮긴다.
    - 두번째 좌표에 다른 색깔의 체스 말이 있는 경우 해당 체스 말을 잡는다.
- 체스 게임이 종료될 때까지 위 두 작업을 반복한다.
    - 게임 종료는 명령어 'end'를 입력받거나 체스 말 king이 잡힌 경우이다.
    - 게임이 종료될 경우 현재 점수를 출력한 후 콘솔을 종료한다.
    - 명령어 'status'를 입력한 경우 현재 상태의 점수를 출력한다.

# 데이터베이스 스키마
CREATE DATABASE chess DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE game ( id INT NOT NULL, turn VARCHAR(10) NOT NULL, PRIMARY KEY (id) );

CREATE TABLE piece ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, point VARCHAR(10) NOT NULL, color VARCHAR(10) NOT NULL, type VARCHAR(10) NOT NULL );