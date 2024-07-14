# compose-fading-edges
The smoothest, most seamless Compose fading edges for Column/LazyColumn. Check out [this Medium article](https://medium.com/@nikonof.m.i/truly-beautiful-fading-edges-in-jetpack-compose-4b6753573d50).

Below, you can see a side-by-side comparison of a standard Compose fading edge implemented with a linear gradient (on the left) and a nonlinear gradient (on the right) implemented in this repository.

![fading_edge_side_by_side](https://github.com/nikonovmi/compose-fading-edges/assets/9309651/87cbacd9-c8b6-4c55-a98e-38cef60dc1d9)

# Quck start
Simply copy and paste [this modifier](https://gist.github.com/nikonovmi/11f983f64a915d29ceaa2dbdc3d6af59) into your project, and use it as follows:

```
val scrollableState = rememberLazyListState()
LazyColumn(
    modifier = Modifier
        .fadingEdges(scrollableState),
    state = scrollableState,
) {
    items(viewState.items) {
      // list content
    }
}
```
