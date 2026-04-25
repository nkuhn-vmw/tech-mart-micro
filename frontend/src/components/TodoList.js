import React, { useEffect, useState } from 'react';

const TodoList = () => {
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchTodos = async () => {
      try {
        const response = await fetch('/api/todos');
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        setTodos(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };
    fetchTodos();
  }, []);

  if (loading) {
    return <div className="text-center py-4">Loading...</div>;
  }

  if (error) {
    return <div className="text-center py-4 text-red-500">Error: {error}</div>;
  }

  return (
    <div className="space-y-2">
      {todos.length === 0 ? (
        <p className="text-center py-4 text-gray-500">No todos found.</p>
      ) : (
        todos.map((todo) => (
          <div key={todo.id} className="flex items-center justify-between p-2 border rounded bg-white">
            <span className={todo.completed ? 'line-through text-gray-500' : ''}>{todo.title}</span>
            <span className="text-sm text-gray-400">{new Date(todo.createdAt).toLocaleDateString()}</span>
          </div>
        ))
      )}
    </div>
  );
};

export default TodoList;
