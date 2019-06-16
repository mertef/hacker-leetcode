<div id="table-of-contents">
<h2>Table of Contents</h2>
<div id="text-table-of-contents">
<ul>
<li><a href="#sec-1">1. 2D Array - DS</a></li>
<li><a href="#sec-2">2. Code swift</a></li>
</ul>
</div>
</div>


# 2D Array - DS<a id="sec-1" name="sec-1"></a>

Give a 6 X 6 2D array, arr:

<p class="verse">
-9 -9 -9 1 1 1<br  />
0  -9 0  4 3 2<br  />
-9 -9 -9 1 2 3<br  />
0  0  8  6 6 0<br  />
0  0  0  -2 0 0<br  />
0  0  1  2 4 0<br  />
We calculate the following 16 hourglass values<br  />
-63, -34, -9, 12,<br  />
-10, 10, 28, 23,<br  />
-27, -11, -2, 10,<br  />
9, 17, 25, 18<br  />
</p>

# Code swift<a id="sec-2" name="sec-2"></a>

     1  func hourglassSum(arr: [[Int]]) -> Int {
     2    var max = Int.min
     3    let rowMax = arr.count
     4    let colMax = arr[0].count
     5    let hgrowMax = 3
     6    let hgcolMax = 3
     7   var houreglass = [[Int]](repeating: [Int](repeating: 0, count: hgcolMax), count: hgrowMax)
     8      for i in stride(from: 0, to: rowMax, by: 1) {
     9      for j in stride(from: 0, to: colMax, by: 1) {
    10          if i + hgrowMax <= rowMax && j + hgcolMax <= colMax{
    11              let ifrom = i
    12              let jfrom = j
    13              for ii in ifrom..<ifrom + hgrowMax {
    14                  for jj in jfrom..<jfrom + hgcolMax {
    15                      houreglass[ii - ifrom][jj - jfrom] = arr[ii][jj]
    16                  }
    17              }
    18              let sum = getSumOfHoureglass(hgglass: houreglass)
    19              //print("sum = \(sum)")
    20              if max < sum {
    21                  max = sum
    22              }
    23          }
    24      }
    25      }
    26      //print("max = \(max)")
    27    return max
    28  }
    29  func getSumOfHoureglass(hgglass:[[Int]]) -> Int{
    30      var sum = 0
    31      for i in 0..<hgglass.count {
    32      for j in 0..<hgglass[0].count {
    33  
    34          let a  = hgglass[i][j]
    35          sum += a
    36          //print("\(a)", separator: " ", terminator: " ")
    37      }
    38       //print("")
    39      }
    40      sum -= (hgglass[1][0] + hgglass[1][2])
    41  //    print("")
    42      return sum
    43  }
