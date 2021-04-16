let calculateProduct = function calculateProduct() {product = 0
time = 1
while (time <= number1)
{product = (product+number2)
time = (time+1)}
console.WriteLine("Enter the low value of the range: ");
lowValue = readline();
console.WriteLine("Enter the high value of the range: ");
highValue = readline();
if( lowValue > highValue )
{swapBoundaries();if( option = "P" ) {playGame();} else {if( option = "B" ) {showBalance();} else {console.WriteLine("ERROR: Invalid Command!");console.WriteLine("Enter the first number: ");getPositiveValue();number1 = positiveValueconsole.WriteLine("Enter the second number: ");getPositiveValue();number2 = positiveValuecalculateProduct();console.WriteLine("The product is: "+product);}
calculateProduct();