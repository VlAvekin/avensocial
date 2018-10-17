<h1>AVENSOCIAL</h1>

<h3>This is my social networks.</h3>
 
HTTP methods:

Get /messages
~~~
[{id=1, text=1 messages}, {id=2, text=2 messages}, {id=3, text=3 messages}]
~~~

Put /messages/1
~~~
[{id=1, text=1 messages}]
~~~


~~~
fetch(
  '/message', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ text: 'Fourth message'})
  }
).then(console.log))
~~~

// GET all
~~~
fetch('/message/').then(response => response.json().then(console.log))
~~~
// GET one
~~~
fetch('/message/2').then(response => response.json().then(console.log))
~~~

// POST add new one
~~~
fetch(
  '/message', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ text: 'Fourth message (4)', id: 10 })
  }
).then(result => result.json().then(console.log))
~~~

// PUT save existing
~~~
fetch(
  '/message/4', 
  { 
    method: 'PUT', 
    headers: { 'Content-Type': 'application/json' }, 
    body: JSON.stringify({ text: 'Fourth message', id: 10 })
  }
).then(result => result.json().then(console.log));
~~~

// DELETE existing
~~~
fetch('/message/4', { method: 'DELETE' }).then(result => console.log(result))
~~~

