let currentdate = new Date();

let Labs = [
  new Date("9/28/2022"),
  new Date("10/26/2022"),
  new Date("11/23/2022"),
  new Date("12/7/2022"),
];

let count = 1;
for (element of Labs) {
  let date = element.getTime() - currentdate.getTime();

  let Difference_In_Days = date / (1000 * 3600 * 24);
  console.log(`lab ${count++} is due in ${Math.ceil(Difference_In_Days) + 1} days`);
}
