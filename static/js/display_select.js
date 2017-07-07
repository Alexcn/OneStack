<!-- 展示样式 -->
function changeDisplay(index){
  if (index === 1) {
      {
          document.getElementById("show_col").style.display = "";
          document.getElementById("show_table").style.display = "none";
      }
  } else if (index === 2) {
      {
          document.getElementById("show_col").style.display = "none";
          document.getElementById("show_table").style.display = "";
      }
  }
}
<!-- /展示样式 -->