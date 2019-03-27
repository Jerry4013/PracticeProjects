// var student;
// var names = ["成秋男","邓茗芮","李冬怡","路海琳","潘今西","沈洳栖","田田", "吴西蒙","汪凯泽",
//     "王策","王语静","杨岳桥","周宗乔","壮壮", "朱厚霖", "赵佳玉" ];
// function initial(names) {
//     for (var i = 0; i < names.length; i++) {
//         student[i] = {name:names[i], rank:i, level:0,point: 0};
//     }
//     return student;
// }
// student = initial(names);
// for (var studentKey in student) {
//     document.write("<tr>");
//     var temp = student[studentKey];
//     for (var prop in temp) {
//         document.write("<td>",temp[prop], "</td>");
//     }
//     document.write("</tr>");
// }

for (var i = 0; i < 16; i++) {
    document.write("<tr><td>", i+1 ,"</td><td></td><td></td><td></td></tr>")
}
