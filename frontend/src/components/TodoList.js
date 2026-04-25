import React, { useEffect, useState } from 'react';

// TodoList component – fetches todos from the backend and displays them
export default function TodoList() {
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

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

  useEffect(() => {
    fetchTodos();
  }, []);

  if (loading) {
    return <div className="text-center py-4">Loading todos...</div>;
  }

  if (error) {
    return <div className="text-center py-4 text-red-600">Error: {error}</div>;
  }

  if (todos.length === 0) {
    return <div className="text-center py-4 text-gray-500">No todos found.</div>;
  }

  return (
    <ul className="space-y-2">
      {todos.map((todo) => (
        <li
          key={todo.id}
          className="flex items-center justify-between p-3 bg-white border rounded"
        >
          <span className={todo.completed ? 'line-through text-gray-500' : ''}>
            {todo.title}
          </span>
          <span className="text-sm text-gray-400">
            {new Date(todo.createdAt).toLocaleDateString()}
          </span>
        </li>
      ))}
    </ul>
  );
}
