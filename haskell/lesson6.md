# Topics in Advanced Computing Lesson 6: Defining Modules and Types

# Last time

* Questions?
* Finish up notes:
  * [Data.Char](lesson5.html#datachar)
  * [Data.Map](lesson5.html#datamap)
  * [Data.Set](lesson5.html#dataset)
  * [Defining Modules](lesson5.html#defining-modules)

# Breaking up

* Make a folder called `Geometry`
* Create three files: `Sphere.hs`, `Cuboid.hs`, `Cube.hs`.

Sphere.hs:

```haskell
module Geometry.Sphere
(volume,
area
) where

volume :: Float -> Float
volume radius = (4.0 / 3.0) * pi * (radius ^ 3)

area :: Float -> Float
area radius = 4 * pi * (radius ^ 2)
```

Cuboid.hs:

```haskell
module Geometry.Cuboid
( volume
, area
) where

volume :: Float -> Float -> Float -> Float
volume a b c = rectangleArea a b * c

area :: Float -> Float -> Float -> Float
area a b c = rectangleArea a b * 2 + rectangleArea a c * 2 + rectangleArea c b * 2

rectangleArea :: Float -> Float -> Float
rectangleArea a b = a * b
```

Cube.hs:

```haskell
module Geometry.Cube
( volume
, area
) where

import qualified Geometry.Cuboid as Cuboid

volume :: Float -> Float
volume side = Cuboid.volume side side side

area :: Float -> Float
area side = Cuboid.area side side side
```

Then:

> ghci> :l Geom.Sphere Geom.Cube  
> [1 of 3] Compiling Geom.Cuboid        ( Geom/Cuboid.hs, interpreted)  
> [2 of 3] Compiling Geom.Cube          ( Geom/Cube.hs, interpreted)  
> [3 of 3] Compiling Geom.Sphere        ( Geom/Sphere.hs, interpreted)  
> Ok, three modules loaded.  
> ghci> Geom.Cube.volume 2.0  
> 8.0

# Algebraic types

```haskell
data MyBool = MyFalse | MyTrue

myAnd :: MyBool -> MyBool -> MyBool
myAnd MyFalse _ = MyFalse
myAnd MyTrue x = x
```

Unfortunately can't print these out. What happens? Solution: add `deriving Show` at the end of the definition.

* :t MyFalse?
* :t MyBool?
* :k MyBool?

> :k Int  
> Int :: *

Q: "What *kind* of type is Int?"  
A: A concrete type ('*' means concrete type: takes no parameters).

What would be an example of something that might take a parameter? A Map (from Data.Map). Try checking its kind.

## Definitions

* data defines a new type
* After the equals sign: value constructors
* Pipe is an "or"

## Shapes

* Represent a circle: (x, y) center and radius
* Represent a rectangle: opposite corners.

```haskell
data Shape = Circle Float Float Float | Rectangle Float Float Float Float deriving Show
```

* :t Circle?
* :t Rectangle?

Value constructors **are functions**.

```haskell
area :: Shape -> Float  
area (Circle _ _ r) = pi * r ^ 2  
area (Rectangle x1 y1 x2 y2) = (abs $ x2-x1 ) * (abs $ y2-y1)
```

Test out a few areas.

## Better version

Introduce a `Point` type, that makes `Circle` and `Rectangle` easier to understand.

```haskell
data Point = Point Float Float deriving Show
data Shape = Circle Point Float | Rectangle Point Point deriving Show

area :: Shape -> Float  
area (Circle _ r) = pi * r ^ 2  
area (Rectangle (Point x1 y1) (Point x2 y2)) = (abs $ x2-x1 ) * (abs $ y2-y1)

origin :: Point
origin = Point 0 0

originCircle :: Float -> Shape
originCircle = Circle origin -- "point-free" style

moveTo :: Point -> Shape -> Shape
moveTo p (Circle _ r) = Circle p r 
moveTo p@(Point x0 y0) (Rectangle (Point x1 y1) (Point x2 y2)) = Rectangle p $ Point (x0 + x2-x1) (y0 + y2 - y1)
```

`moveTo p` moves a Circle to center it at p, and moves a Rectangle so that one of its corners is at p.

## Records

How would we encapsulate a type for Time? Keep track of hour, minute, and AM / PM? For a Course?

Instead of using separate fields, we can name the fields with **records**. Then there are auto-generated functions to retrieve those fields.

```haskell
data AmPm = AM | PM deriving Show
data Time = Time { hour :: Int, minute :: Int, amPm :: AmPm } deriving Show

data Course = Course { courseName :: String, crn :: Int, day :: String, startTime :: Time, endTime :: Time} deriving Show
```

Then:

> ghci> c = Course { courseName = "CS2", crn = 1540, day = "MR", startTime = Time { hour = 10, minute = 30, amPm = AM }, endTime = Time { hour = 12, minute = 10, amPm = PM } }  
> ghci> courseName c  
> "CS2"  
> ghci> startTime c  
> Time {hour = 10, minute = 30, amPm = AM}  
> ghci> hour $ startTime c  
> 10  
