<template>
  <div class="app-container">
    <div style="margin-bottom: 10px;">
      <el-button
        type="primary"
        size="mini"
        icon="el-icon-download"
        @click="dialogVisible = true"
      >
        Import Excel
      </el-button>
      <el-button
        type="primary"
        size="mini"
        icon="el-icon-upload2"
        @click="exportData"
      >Export Excel</el-button>
      <el-table :data="list" border row-key="id" lazy :load="getChildren">
        <el-table-column label="名称" align="left" prop="name" />
        <el-table-column label="编码" prop="dictCode" />
        <el-table-column label="值" align="left" prop="value" />
      </el-table>
    </div>

    <el-dialog title="Data Dict Import" :visible.sync="dialogVisible" width="30%">
      <el-form>
        <el-form-item label="Select Excel File">
          <el-upload
            :auto-upload="true"
            :multiple="false"
            :limit="1"
            :on-exceed="fileUploadExceed"
            :on-success="fileUploadSuccess"
            :on-error="fileUploadError"
            :action="BASE_API + '/admin/core/dict/import'"
            name="file"
            accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
          >
            <el-button size="small" type="primary">Upload</el-button>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">
          Cancel
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import dictApi from '@/api/core/dict'
export default {
  // 定义数据
  data() {
    return {
      dialogVisible: false,
      BASE_API: process.env.VUE_APP_BASE_API,
      list: []
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fileUploadExceed() {
      this.$message.warning('Only Select One File')
    },

    fileUploadSuccess(response) {
      if (response.code === 0) {
        this.$message.success('Data Import Success!')
        this.dialogVisible = false
        this.fetchData()
      } else {
        this.$message.error(response.message)
      }
    },

    fileUploadError() {
      this.$message.error('Failed')
    },

    exportData() {
      window.location.href = this.BASE_API + '/admin/core/dict/export'
    },
    // 调用api层获取数据库中的数据
    fetchData() {
      dictApi.listByParentId(1).then(response => {
        this.list = response.data.list
      })
    },

    getChildren(row, treeNode, resolve) {
      dictApi.listByParentId(row.id).then(response => {
        resolve(response.data.list)
      })
    }
  }
}
</script>
