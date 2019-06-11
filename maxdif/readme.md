<div id="table-of-contents">
<h2>Table of Contents</h2>
<div id="text-table-of-contents">
<ul>
<li><a href="#sec-1">1. Find the max Difference in a given array</a></li>
<li><a href="#sec-2">2. swift code to solve the problem</a></li>
<li><a href="#sec-3">3. test cases</a></li>
</ul>
</div>
</div>


# Find the max Difference in a given array<a id="sec-1" name="sec-1"></a>

<p class="verse">
for a given array:<br  />
e.g [2, 3, 10, 2, 4, 8, 1]<br  />
differences are calculated as:<br  />
3 - =<br  />
10 - [3,2] = [7,8]<br  />
4 -[2,3,2] = [2,1,2]<br  />
8 - [4, 2, 3, 2] = [4, 6, 5, 6]<br  />
so the maximum is found at 10 - 2 = 8<br  />
</p>

# swift code to solve the problem<a id="sec-2" name="sec-2"></a>

     1  func maxDifference(arr:[Int]) -> Int {
     2      var maxdif = 0
     3      for i in stride(from: 1, to: arr.count, by: 1) {
     4      let v = arr[i]
     5      for j in stride(from: 0, to: i, by: 1) {
     6          if v > arr[j] {
     7            let d = v - arr[j]
     8              if maxdif < d {
     9                  maxdif = d
    10              }
    11          }
    12      }
    13      }
    14      print("max dif = \(maxdif)")
    15      return maxdif
    16  }

# test cases<a id="sec-3" name="sec-3"></a>

     func testMaxDif()  {
    //        var arr = [2, 3, 10, 2, 4, 8, 1]
            var arr = [1, 2, 6, 4]
    
            maxDifference(arr: arr)
            
        }

<div id="footnotes">
<h2 class="footnotes">Footnotes: </h2>
<div id="text-footnotes">

<div class="footdef"><sup><a id="fn.1" name="fn.1" class="footnum" href="#fnr.1">1</a></sup> <p>DEFINITION NOT FOUND.</p></div>

<div class="footdef"><sup><a id="fn.2" name="fn.2" class="footnum" href="#fnr.2">2</a></sup> <p>DEFINITION NOT FOUND.</p></div>


</div>
</div>
