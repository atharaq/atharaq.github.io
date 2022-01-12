<script src="https://sagecell.sagemath.org/static/embedded_sagecell.js"></script>
<script>sagecell.makeSagecell({"inputLocation": ".sage"});</script>


# Testing out Sage code

This is just a test page to see how Github Pages handles embedding a SageCell. We used the following code:

```python`
from sage.misc.prandom import randrange

def grid(v1, v2, endpoints=[-3, 3, -3, 3], color1='blue', color2='red'):
    G = Graphics()
    for i in range(endpoints[0], endpoints[1]):
        for j in range(endpoints[2], endpoints[3]):
            base = i * v1 + j*v2
            G += arrow(base, base+v1, color=color1)
            G += arrow(base, base+v2, color=color2)
    return G

v = vector([randrange(-5, 5) for i in range(2)])
w = vector([randrange(-5, 5) for i in range(2)])
print('v = ' + str(v))
print('w = ' + str(w))
G = grid(v, w)
G.show()
```

## Sage

<div class="sage">
  <script type="text/x-sage">
  from sage.misc.prandom import randrange

  def grid(v1, v2, endpoints=[-3, 3, -3, 3], color1='blue', color2='red'):
      G = Graphics()
      for i in range(endpoints[0], endpoints[1]):
          for j in range(endpoints[2], endpoints[3]):
              base = i * v1 + j*v2
              G += arrow(base, base+v1, color=color1)
              G += arrow(base, base+v2, color=color2)
      return G

  v = vector([randrange(-5, 5) for i in range(2)])
  w = vector([randrange(-5, 5) for i in range(2)])
  print('v = ' + str(v))
  print('w = ' + str(w))
  G = grid(v, w)
  G.show()
  </script>
</div>
