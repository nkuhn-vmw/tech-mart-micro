import React from 'react';
import { Link } from 'react-router-dom';

const NAVBAR_COLOR = '#0056a6';

function Navbar() {
  return (
    <nav style={{ padding: '1rem', background: NAVBAR_COLOR }}>
      <Link to="/" style={{ marginRight: '1rem' }}>Home</Link>
      <Link to="/about">About</Link>
    </nav>
  );
}

export default Navbar;
