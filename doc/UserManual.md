# 사용자 매뉴얼

## 노트북 상태

<figure>

![노트북 상태관리](file/notebook-fsm.png)

<figcaption>

[노트북상태관리][1]

</figcaption>
</figure>

<details>
<summary>Mermaid 버전</summary>

```mermaid
stateDiagram-v2
    state "중립" as neutral
    state "노트북 메뉴" as notebook_menu
    state "오브젝트 선택" as object_focused
    state "오브젝트 수정" as object_editing
    state "오브젝트 미리보기" as object_preview
    state "오브젝트 메뉴" as object_menu
    
    [*] --> neutral: 열기
    neutral --> notebook_menu: 빈공간 우클릭
    notebook_menu --> neutral: 빈공간 클릭
    notebook_menu --> neutral: 기타 기능 실행
    notebook_menu --> object_focused: 오브젝트 추가
    neutral --> object_focused: 오브젝트 클릭
    object_focused --> neutral: 빈공간 클릭
    object_focused --> object_editing: 더블 클릭
    object_focused --> object_menu: 오브젝트 우클릭
    object_editing --> object_focused: 수정 완료
    object_editing --> neutral: 빈공간 클릭
    object_focused --> object_preview: 드래그
    object_preview --> object_focused: 빈 공간에 드랍
    object_preview --> object_menu: 다른 오브젝트에 드랍
    object_menu --> object_focused: 오브젝트 기능 실행
    object_menu --> neutral: 기타 기능 실행
```

</details>

## 참고

### 외부 링크

1. [노트북 상태관리][1]

[1]: https://www.figma.com/board/aR9QaELgTdhOUnaIHNK5pt/%EB%85%B8%ED%8A%B8%EB%B6%81-%EC%83%81%ED%83%9C%EA%B4%80%EB%A6%AC