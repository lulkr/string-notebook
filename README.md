# String Notebook

<figure>

![Photo by cottonbro studio from Pexels: https://www.pexels.com/photo/close-up-of-a-bulletin-board-8369515](doc/file/pexels-cottonbro-8369515.jpg)

<figcaption><a href="https://www.pexels.com/photo/close-up-of-a-bulletin-board-8369515">Photo by cottonbro studio from Pexels</a></figcaption>
</figure>

시각화한 문서는 큰 도움이 된다. 이런 도구는 많이 있지만 만족스럽지 않다. 없으면 만들어야지 별 수 있나. 그래서 시작한다.

## 목표

1. **시각화** : 노드와 엣지로 표현한다.
2. **버전 관리** : 각각의 버전이 어떤 차이가 있는지 비교할 수 있어야 한다.
3. **내용과 형식의 분리** : 내용과 시각적 정보가 뒤섞이지 않도록 한다.
4. **확장성** : 표준화된 입출력 도구를 사용해 여러 형식으로 입출력 할 수 있어야 한다.

## 다른 도구

### [yEd][2]

매우 훌륭한 도구다. 특히 [GraphML][3] 형식의 텍스트 파일이라 `diff`를 사용할 수 있다는 게 매우 큰 장점이다.

하지만 다음 문제가 있다.

1. 위치를 바꾸는 정도로 파일의 많은 부분이 바뀌는 경우가 많아 `diff`가 의미없는 경험이 되는 경우가 많다.
2. 노드가 없으면 선을 그을 수 없다는 치명적인 문제가 존재한다.
3. [GraphML][3] 형식 자체가 그리 인기가 없어 확장성이 떨어진다.
4. 노드 그룹 기능이 제한적이고, 안예쁘다.
5. 내용과 시각적 정보가 뒤섞여 있어서 내용의 변화를 추적하기 어렵다.

### 마인드맵

[FreeMind][4] 같은 도구로 마인드맵도 괜찮은 도구다.

하지만

1. 노드 사이의 관계가 제한적이다. 확장성이 많이 부족하다.
2. 대부분 `diff`가 불가능하다.
3. 예쁜 건 비싸다. 안예쁜 건 예쁘게 만들기 어렵다.

### [Mermaid][5]

`diff`가 가능하기 때문에 [module-graph][6] 같은 플러그인으로 멀티모듈 프로젝트를 가시화 할 때 자주 사용한다.

하지만

1. 그릴 수 있는 형식이 제한적이다.
2. 불편하다. 손으로 그려지게 타이핑해야 한다.
3. 플러그인의 기능에 의존적이다. [module-graph][6]는 모듈의 순서가 수시로 바뀌는 등의 문제가 있다.

### 기타 도구

- [OneNote][7] : `diff`가 불가능하다. 그리고 내용 사이의 연결 관계를 표현하기 어렵다.
- [PowerPoint][8] : 크기 제한이 있고, `diff`가 불가능하다.
- [FigJam][9] : 버전 관리가 되지만 `diff`는 불가능하다. 그리고 [GitHub][10]의 `README.md`에 넣을 수 없다.

## 모듈

### Module Graph

## 참고

1. [Photo by cottonbro studio from Pexels][1]
2. [yEd][2]
3. [GraphML][3]
4. [FreeMind][4]
5. [Mermaid][5]
6. [module-graph][6]
7. [OneNote][7]
8. [PowerPoint][8]
9. [FigJam][9]
10. [GitHub][10]

[1]: https://www.pexels.com/photo/close-up-of-a-bulletin-board-8369515

[2]: https://www.yworks.com/products/yed

[3]: http://graphml.graphdrawing.org

[4]: https://freemind.sourceforge.io/wiki/index.php/Main_Page

[5]: https://mermaid.js.org

[6]: https://github.com/iurysza/module-graph

[7]: https://www.onenote.com

[8]: http://office.microsoft.com/PowerPoint

[9]: https://www.figma.com/figjam

[10]: https://github.com