function doFirst(){
   document.getElementById('exampleFormControlFile1').onchange = fileChange;
}

function fileChange(){
    //只有一個檔案
    let file = document.getElementById('exampleFormControlFile1').files[0];

    //======================================
    let readFile = new FileReader();
    readFile.readAsDataURL(file);
    readFile.addEventListener('load',function(){
        // document.getElementById('fileContent').value = readFile.result;
        // document.getElementById('fileContent').value = e.target.result;
        // src 圖片路徑
        // document.getElementById('image').src = this.result; //匿名不能用
        // 如果需要設定多個參數，就用一個變數去存物件。
        let image = document.getElementById('image');
        image.src = this.result;
        //設定CSS屬性裡面的max，讓寬高最高限制在你設定的數值。
        image.style.maxWidth = '400px';
        image.style.maxHeight = '400px';
    });
}

window.addEventListener('load',doFirst);