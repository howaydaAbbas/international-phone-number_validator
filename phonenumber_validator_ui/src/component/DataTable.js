import React, { useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid'
import axios from 'axios';

const columns = [
  { field: 'number', headerName: 'Number' , width : 450},
  { field: 'valid', headerName: 'Valid', width: 300 },
  { field: 'country', headerName: 'Country', width: 300 },
  { field: 'countryCode', headerName: 'Country Code', width: 600 }
]

const DataTable = () => {

  const [tableData, setTableData] = useState([])

  useEffect(() => {
    axios("http://localhost:8080/api/validatePhoneNumbers")
      .then((res) => setTableData(res.data.phoneNumberValidationResult))

  }, [])

  return (
    <div style={{ height: 700, width: '100%' }}>
      <DataGrid
        rows={tableData}
        columns={columns}
        pageSize={12}
        getRowId={(row) => row.number}
      />
    </div>
  )
}

export default DataTable