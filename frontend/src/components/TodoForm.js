import React, { useState } from 'react';

// TodoForm component – posts a new todo to the backend
export default function TodoForm({ onTodoAdded }) {
  const [title, setTitle] = useState('');
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null);
    if (!title.trim()) {
      setError('Title is required');
      return;
    }
    setLoading(true);
    try {
      const response = await fetch('/api/todos', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, completed: false }),
      });
      if (!response.ok) {
        const err = await response.text();
        throw new Error(err || 'Failed to create todo');
      }
      const newTodo = await response.json();
      setTitle('');
      if (onTodoAdded) onTodoAdded(newTodo);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="max-w-md mx-auto mt-4 p-4 border rounded shadow">
      <h2 className="text-xl mb-2">Add Todo</h2>
      {error && <div className="text-red-600 mb-2">{error}</div>}
      <div className="mb-2">
        <input
          type="text"
          placeholder="Todo title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          className="w-full border px-2 py-1 rounded"
          disabled={loading}
        />
      </div>
      <button
        type="submit"
        className="bg-blue-600 hover:bg-blue-700 text-white py-1 px-4 rounded"
        disabled={loading}
      >
        {loading ? 'Saving...' : 'Add Todo'}
      </button>
    </form>
  );
}
