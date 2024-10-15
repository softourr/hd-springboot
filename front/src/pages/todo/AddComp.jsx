import React, { useState } from "react";
import useCustomMove from "../../hooks/useCustomMove";
import { postAdd } from "../../api/todoApi";
import ResultModal from "../../components/common/ResultModal";

// 초기데이터 만드는 이유 : 해당 값이 에러나는 경우가 있기 때문에
const initState = {
  title: "",
  writer: "",
  dueDate: "",
};

function AddComp() {
  const [todo, setTodo] = useState(initState);
  const [result, setResult] = useState(null);

  const { moveToList } = useCustomMove(); // 작성하고 List페이지로 돌아가기 위해

  const handleChangeTodo = (e) => {
    todo[e.target.name] = e.target.value; // title 값만 변경
    setTodo({ ...todo });
  };

  const handleClickAdd = () => {
    postAdd(todo)
      .then((result) => {
        console.log(result);

        setResult(result.TNO);
        setTodo({ ...initState });
      })
      .catch((e) => {
        console.error(e);
      });
  };

  const closeModal = () => {
    setResult(null);
  };

  return (
    <div>
      {/* TODO modal */}
      {result ? (
        <ResultModal
          title="글쓰기추가"
          content={`새로운 ${result} 추가완료`}
          callbackFn={closeModal}
        />
      ) : null}

      <div className="flex gap-2">
        <div>title</div>
        <input
          type="text"
          name="title" // input이라는 name으로 값을 넘기는 것
          className="border-gray-300 border-2"
          onChange={handleChangeTodo}
        />
      </div>
      <div className="flex gap-2">
        {todo.writer}
        <div>writer</div>
        <input
          type="text"
          name="writer" // input이라는 name으로 값을 넘기는 것
          className="border-gray-300 border-2"
          onChange={handleChangeTodo}
        />
      </div>
      <div className="flex gap-2">
        {todo.dueDate}
        <div>dueDate</div>
        <input
          type="date"
          name="writer" // input이라는 name으로 값을 넘기는 것
          className="border-gray-300 border-2"
          onChange={handleChangeTodo}
        />
      </div>
      <div className="flex justify-end my-3">
        <button
          className="bg-green-500 rounded py-2 px-4 text-white"
          onClick={handleClickAdd}
        >
          글쓰기
        </button>
      </div>
    </div>
  );
}

export default AddComp;
