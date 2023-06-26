import { useEffect } from "react";

function useTitle(title) {
  useEffect(() => {
    // const titleElement = document.getElementsByTagName("title")[0];
    // titleElement.innerHTML = `감정 일기장`;
    document.title = title;
  }, [title]);
}
export default useTitle;
