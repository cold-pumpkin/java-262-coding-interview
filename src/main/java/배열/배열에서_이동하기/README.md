# 문제 5.4 배열에서 이동하기
### Q. 길이가 n인 배열 A가 주어졌을 때, 배열의 시작점에서 마지막 지점까지 도달할 수 있는지 판단하는 프로그램을 작성하라. (단, `A[i]`는 `i`번째 위치에서 나아갈 수 있는 최대 거리를 뜻한다.)

### A. 각 위치에서 도달 가능한 최대 포지션 구하기 
* `i`번째 위치에서 닿을 수 있는 최대 위치 = `i + A[i]`
* 각 포지션에서 도달할 수 있는 최대 위치를 구해보기

#### 복잡도
* 리스트를 순차적으로 탐색하므로 시간 복잡도는 `O(n)`
* `int`형 변수만 추가적으로 사용하므로 공간 복잡도는 `O(1)`